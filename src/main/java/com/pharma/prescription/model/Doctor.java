package com.pharma.prescription.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "NPI is required")
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
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Address is required")
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @NotNull(message = "password is required")
    private User user;




}
