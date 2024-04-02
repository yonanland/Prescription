package com.pharma.prescription.service;

import com.pharma.prescription.dto.PatientDTO;
import com.pharma.prescription.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);
    List<PatientDTO> searchPatients(String firstName, String lastName, LocalDate dateOfBirth);
}
