package org.neyamul.ecomarceproject.services;

import org.modelmapper.ModelMapper;
import org.neyamul.ecomarceproject.model.Address;
import org.neyamul.ecomarceproject.model.User;
import org.neyamul.ecomarceproject.payload.AddressDTO;
import org.neyamul.ecomarceproject.repository.AddressRepository;
import org.neyamul.ecomarceproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {
        Address address = modelMapper.map(addressDTO, Address.class);

        List<Address> addressList = user.getAddresses();
        addressList.add(address);
        user.setAddresses(addressList);

        address.setUser(user);
        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress, AddressDTO.class);
    }


    @Override
    public AddressDTO getAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + addressId));
        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) {
    Address existingAddress = addressRepository.findById(addressId)
            .orElseThrow(() -> new RuntimeException("Address not found with id: " + addressId));

    existingAddress.setRecipientName(addressDTO.getRecipientName());
    existingAddress.setAddressLine1(addressDTO.getAddressLine1());
    existingAddress.setAddressLine2(addressDTO.getAddressLine2());
    existingAddress.setCity(addressDTO.getCity());
    existingAddress.setState(addressDTO.getState());
    existingAddress.setPostalCode(addressDTO.getPostalCode());
    existingAddress.setCountry(addressDTO.getCountry());

    Address updatedAddress = addressRepository.save(existingAddress);

    User user = updatedAddress.getUser();
    user.getAddresses().removeIf(address1 -> address1.getAddressId().equals(addressId) );
    user.getAddresses().add(updatedAddress);
    userRepository.save(user);

    return modelMapper.map(updatedAddress, AddressDTO.class);
    }

    @Override
    public String deleteAddress(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + addressId));
        User user = address.getUser();
        user.getAddresses().removeIf(address1 -> address1.getAddressId().equals(addressId));
        userRepository.save(user);
        addressRepository.delete(address);
        return "Address : " + addressId + " deleted";
    }

    @Override
    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        if (!addresses.isEmpty()) {
            return addresses.stream()
                    .map(address -> modelMapper.map(address, AddressDTO.class))
                    .toList();
        }

        throw new RuntimeException("No addresses found");
    }

    @Override
    public List<AddressDTO> getUserAddresses(User user) {
        List<Address> addresses = user.getAddresses();
        if (!addresses.isEmpty()) {
            return addresses.stream()
                    .filter(address -> address.getUser().getUserId().equals(user.getUserId()))
                    .map(address -> modelMapper.map(address, AddressDTO.class))
                    .toList();
        }
        throw new RuntimeException("No addresses found for user with id: " + user.getUserId());
    }

}

