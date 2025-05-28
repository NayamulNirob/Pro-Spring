package org.neyamul.ecomarceproject.services;


import org.neyamul.ecomarceproject.model.User;
import org.neyamul.ecomarceproject.payload.AddressDTO;

import java.util.List;

public interface AddressService {

    AddressDTO createAddress(AddressDTO addressDTO, User user);

    AddressDTO getAddressById(Long addressId);

    AddressDTO updateAddress(Long addressId, AddressDTO addressDTO);

    String deleteAddress(Long addressId);

    List<AddressDTO> getAllAddresses();

    List<AddressDTO> getUserAddresses(User user);
}
