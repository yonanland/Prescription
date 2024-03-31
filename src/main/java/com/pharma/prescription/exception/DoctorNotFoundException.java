package com.pharma.prescription.exception;

public class DoctorNotFoundException extends Exception{
    public DoctorNotFoundException() {
        super();
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
