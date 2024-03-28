package com.pharma.prescription.service;

import com.pharma.prescription.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient) throws Exception;
    List<Patient> searchPatients(String firstName, String lastName, LocalDate dateOfBirth);
}
