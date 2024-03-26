package com.pharma.prescription.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "NPI is required")
    @Pattern(regexp = "^[0-9]*$", message = "NPI must contain only numbers")
    private Long npiNumber;

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "First name must contain only letters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Last name must contain only letters")
    private String lastName;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank(message = "Fax is required")
    private String fax;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @NotBlank(message = "Address is required")
    private Address address;

    @Override
    public String toString() {
        return String.format("""
                        Doctor info:\s
                        ID: %d,\s
                        NPI#: %d,\s
                        First Name: %s,\s
                        Last Name: %s,\s
                        Email: %s,\s
                        Address: %s,\s
                        Password: %s,\s
                        Phone: %s,\s
                        Fax: %s,\s
                        Specialization: %s
                        
                        
                        """, id, npiNumber, firstName, lastName, email, address, password, phone, fax, specialization);
    }

}
