package com.pharma.prescription.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class DoctorLoginResponseDTO {
    private String firstName;
    private String lastName;
    private String email;

    public DoctorLoginResponseDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
