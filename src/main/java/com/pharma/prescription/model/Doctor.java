package com.pharma.prescription.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "NPI is required")
    private Long npi;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Specialization is required")
    private String specialization;
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Phone is required")
    private String phone;
    @NotBlank(message = "fax is required")
    private String fax;
  
    @ManyToOne
    @JoinColumn(name = "address_id")
    @NotBlank(message = "Address is required")
    private Address address;

    @Override
    public String toString() {
        return String.format("""
                        Doctor info:\s
                        ID: %d,\s
                        npi: %d,\s
                        firstName: %s,\s
                        lastName: %s,\s
                        email: %s,\s
                        address: %s,\s
                        specialization: %s,\s
                        """, id, npi, firstName, lastName, email, address, specialization);
    }
                             
 }
