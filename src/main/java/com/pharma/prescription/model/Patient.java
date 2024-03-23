package com.pharma.prescription.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient", uniqueConstraints = {@UniqueConstraint(columnNames = {"fullName", "dateOfBirth"})})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z '-]+$", message = "Full name must contain only letters and spaces, apostrophes, or hyphens.")
    private String fullName;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateOfBirth;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9.,' -]+$", message = "Invalid address format.")
    private String address;

    @NotBlank
    @Pattern(regexp = "^\\d{7,15}$", message = "Invalid phone number format.")
    private String phoneNumber;

    @NotBlank
    private String insuranceNumber;

}

