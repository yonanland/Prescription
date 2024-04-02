package com.pharma.prescription.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "addresses")
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Street is required.")
    @Pattern(regexp = "^[A-Za-z0-9.,' -]+$", message = "Invalid street format.")
    private String street;
    @NotBlank(message = "City is required.")
    @Pattern(regexp = "^[A-Za-z '-]+$", message = "Invalid city format.")
    private String city;
    @NotBlank(message = "State is required.")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid state format.")
    private String state;
    @NotBlank(message = "Zip is required.")
    @Pattern(regexp = "^\\d{5}$", message = "Invalid ZIP format.")
    private String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
