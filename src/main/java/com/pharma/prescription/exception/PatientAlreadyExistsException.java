package com.pharma.prescription.exception;

public class PatientAlreadyExistsException extends RuntimeException {
    public PatientAlreadyExistsException(String message) {
        super(message);
    }
}
