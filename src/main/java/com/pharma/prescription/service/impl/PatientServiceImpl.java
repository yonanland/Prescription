package com.pharma.prescription.service.impl;

import com.pharma.prescription.Exception.PatientAlreadyExistsException;
import com.pharma.prescription.Exception.PatientProfileNotFoundException;
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

    public Patient createPatient(Patient patient){
        if (patientRepository.findByFirstNameAndLastNameAndDateOfBirth(patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth()).isPresent()) {
            throw new PatientAlreadyExistsException("A patient with the same name and date of birth already exists.");
        }
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> searchPatients(String firstName, String lastName, LocalDate dateOfBirth) {
        List<Patient> patients = patientRepository.findByFirstNameAndLastNameAndDateOfBirthOptional(firstName, lastName, dateOfBirth);
        if (patients.isEmpty()) {
            throw new PatientProfileNotFoundException("No patients found matching the search criteria.");
        }
        return patients;
    }
}
