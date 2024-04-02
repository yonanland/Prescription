package com.pharma.prescription.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DoctorResponseDTO(
        Long id,
        String firstName,
        String lastName,
        Long npiNumber,
        @JsonProperty("address")
        AddressDTO addressDTO,
        String specialization,
        String faxNumber,
        String email,
        String phoneNumber,
        String username
) {
}
