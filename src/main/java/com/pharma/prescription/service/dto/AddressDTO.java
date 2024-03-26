package com.pharma.prescription.service.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        String street,
        String city,
        String state,
        @NotBlank
        String zipCode
) {
}
