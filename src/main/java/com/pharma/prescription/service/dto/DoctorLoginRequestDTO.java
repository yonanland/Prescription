package com.pharma.prescription.service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorLoginRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

//    public DoctorLoginRequestDTO(String firstName, String lastName, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }
}


