package com.pharma.prescription.service.impl;

import com.pharma.prescription.model.Patient;
import com.pharma.prescription.repository.PatientRepository;
import com.pharma.prescription.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) throws Exception {
        if (patientRepository.findByFullNameAndDateOfBirth(patient.getFullName(), patient.getDateOfBirth()).isPresent()) {
            throw new Exception("A patient with the same full name and date of birth already exists.");
        }
        return patientRepository.save(patient);
    }

    public Optional<Patient> findPatient(String fullName, LocalDate dateOfBirth) {
        return patientRepository.findByFullNameAndDateOfBirth(fullName, dateOfBirth);
    }

    public List<Patient> searchPatients(String fullName, LocalDate dateOfBirth) {
        return patientRepository.findByFullNameAndDateOfBirthOptional(fullName, dateOfBirth);
    }
}
