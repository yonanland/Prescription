package com.pharma.prescription.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Pattern(regexp = "^[A-Za-z '-]+$", message = "First name must contain only letters and spaces, apostrophes, or hyphens.")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[A-Za-z '-]+$", message = "Last name must contain only letters and spaces, apostrophes, or hyphens.")
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateOfBirth;

    @NotNull
    @Pattern(regexp = "^\\d{7,15}$", message = "Invalid phone number format.")
    private String phoneNumber;

    @NotBlank
    private String insurance;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
   // @Pattern(regexp = "^[A-Za-z0-9.,' -]+$", message = "Invalid address format.")
    private Address address;





}

