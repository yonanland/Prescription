package com.pharma.prescription.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorRequestDTO(

        @NotBlank(message = "first name is required")
        @Pattern(regexp = "^[A-Za-z]+[a-z A-Z'-]*", message = "Please enter a valid name")
        String firstName,
        @Pattern(regexp = "^[A-Za-z]+[a-z A-Z'-]*", message = "Please enter a valid name")
        @NotBlank(message = "last name is required")
        String lastName,
        @NotNull(message = "NPI number is required")
        Long npiNumber,
        @JsonProperty("address")
        @NotNull(message = "Address is required")
        AddressDTO addressDTO,
        @NotBlank(message = "specialization is required")
        String specialization,
        @NotBlank(message = "fax number is required")
        String faxNumber,
        @NotBlank(message = "email is required")
        @Email(message = "email is invalid", flags = {Pattern.Flag.CASE_INSENSITIVE})
        String email,
        @NotBlank(message = "phone number is required")
        String phoneNumber,
        @JsonProperty("user")
        @NotNull(message = "User is required")
        UserDTO userDTO
) {
}
