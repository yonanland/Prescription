package com.pharma.prescription.service;

import com.pharma.prescription.model.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient createPatient(Patient patient) throws Exception;
    Optional<Patient> findPatient(String fullName, LocalDate dateOfBirth);
    List<Patient> searchPatients(String fullName, LocalDate dateOfBirth);
}
