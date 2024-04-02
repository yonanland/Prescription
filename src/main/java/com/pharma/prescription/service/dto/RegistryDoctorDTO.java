package com.pharma.prescription.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pharma.prescription.model.Address;

public record RegistryDoctorDTO(
        String firstName,
        String lastName,
        Long npiNumber,
        @JsonIgnoreProperties("id")
        Address address,
        String specialty,
        String phoneNumber,
        String faxNumber
)  {
}
