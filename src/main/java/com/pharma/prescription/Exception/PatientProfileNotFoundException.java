package com.pharma.prescription.Exception;

public class PatientProfileNotFoundException extends RuntimeException {
    public PatientProfileNotFoundException(String message) {
        super(message);
    }
}
