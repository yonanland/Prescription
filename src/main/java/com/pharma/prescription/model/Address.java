package com.pharma.prescription.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Names")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long address_id;
    private String street;
    private String city;
    private String state;
    private String zip;
}
