package org.neyamul.ecomarceproject.restcontroller;

import jakarta.validation.Valid;
import org.neyamul.ecomarceproject.model.User;
import org.neyamul.ecomarceproject.payload.AddressDTO;
import org.neyamul.ecomarceproject.services.AddressService;
import org.neyamul.ecomarceproject.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressRestController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AuthUtil authUtil;


    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long addressId) {
        AddressDTO addressDTO = addressService.getAddressById(addressId);
        if (addressDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<AddressDTO> addAddress(@Valid @RequestBody AddressDTO addressDTO) {
        User user = authUtil.loggedInUser();
        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO ,user);
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        List<AddressDTO> addresses = addressService.getAllAddresses();
        if (addresses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/user/addresses")
    public ResponseEntity<List<AddressDTO>> getAddressesByUserId() {
        User user = authUtil.loggedInUser();
        List<AddressDTO> addresses = addressService.getUserAddresses(user); // Assuming this method fetches addresses for the user
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }


    @PutMapping("/update/{addressId}")
    public ResponseEntity<AddressDTO> updateAddress(@Valid @PathVariable Long addressId, @RequestBody AddressDTO addressDTO) {
        AddressDTO updatedAddress = addressService.updateAddress(addressId, addressDTO);
        if (updatedAddress == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
        return new ResponseEntity<>("Address with id:  "+ addressId +  " deleted successfully",HttpStatus.OK);
    }
}
