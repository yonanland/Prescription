package com.pharma.prescription.service.adaptor;

import com.pharma.prescription.model.Address;
import com.pharma.prescription.service.dto.AddressDTO;

public class AddressAdapter {

    public static AddressDTO toAddressDTO(Address address) {
        return new AddressDTO(
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZip()
        );
    }

    public static Address toAddress(AddressDTO addressDTO) {
        return new Address(
                addressDTO.street(),
                addressDTO.city(),
                addressDTO.state(),
                addressDTO.zipCode()
        );
    }
}
