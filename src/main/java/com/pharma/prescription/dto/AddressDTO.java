package com.pharma.prescription.dto;

import jakarta.validation.constraints.Pattern;

public class AddressDTO {

    private Long addressId;

    @Pattern(regexp = "^[A-Za-z0-9.,' -]+$", message = "Invalid street format.")
    private String street;

    @Pattern(regexp = "^[A-Za-z '-]+$", message = "Invalid city format.")
    private String city;

    @Pattern(regexp = "^[A-Za-z '-]+$", message = "Invalid state format.")
    private String state;

    @Pattern(regexp = "^\\d{5}$", message = "Invalid ZIP format.")
    private String zip;


    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
