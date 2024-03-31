package com.pharma.prescription.service.impl;

import com.pharma.prescription.dto.PatientDTO;
import com.pharma.prescription.exception.PatientAlreadyExistsException;
import com.pharma.prescription.exception.PatientProfileNotFoundException;
import com.pharma.prescription.model.Patient;
import com.pharma.prescription.repository.PatientRepository;
import com.pharma.prescription.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);

        if (patientRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndDateOfBirth(patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth()).isPresent()) {
            throw new PatientAlreadyExistsException("A patient with the same name and date of birth already exists.");
        }

        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDTO.class);
    }

    @Override
    public List<PatientDTO> searchPatients(String firstName, String lastName, LocalDate dateOfBirth) {
        List<Patient> patients = patientRepository.findByFirstNameAndLastNameAndDateOfBirthOptional(firstName, lastName, dateOfBirth);

        if (patients.isEmpty()) {
            throw new PatientProfileNotFoundException("No patients found matching the search criteria.");
        }

        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }
}
