package com.pharma.prescription.service.dto;

import com.pharma.prescription.model.Role;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        Long id,
        String username,
        @NotBlank(message = "password is required")
        String password,
        Role role
) {
}
