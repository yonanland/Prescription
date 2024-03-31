package com.pharma.prescription.exception;

public class PatientProfileNotFoundException extends RuntimeException {
    public PatientProfileNotFoundException(String message) {
        super(message);
    }
}
