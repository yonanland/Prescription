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
@Entity(name = "Doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private Long npi;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String specialization;
    
    @OneToOne(cascade = CascadeType.ALL)
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
