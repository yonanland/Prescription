package com.pharma.prescription.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Names")
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long address_id;
    @Pattern(regexp = "^[A-Za-z0-9.,' -]+$", message = "Invalid street format.")
    private String street;

    @Pattern(regexp = "^[A-Za-z '-]+$", message = "Invalid city format.")
    private String city;

    @Pattern(regexp = "^[A-Za-z '-]+$", message = "Invalid state format.")
    private String state;

    @Pattern(regexp = "^\\d{5}(-\\d{4})?$", message = "Invalid ZIP format.")
    private String zip;
}
