package com.pharma.prescription.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String dob;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String insurance;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
