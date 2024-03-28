package com.pharma.prescription.controller;

import com.pharma.prescription.model.Patient;
import com.pharma.prescription.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/profiles/new")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> createPatientProfile(@RequestBody Patient patient) throws Exception {
        Patient savedPatient = patientService.createPatient(patient);
        return ResponseEntity.created(URI.create("/patients/profiles/" + savedPatient.getId())).body(savedPatient);
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<List<Patient>> searchPatients(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate dateOfBirth) {

        List<Patient> patients = patientService.searchPatients(firstName, lastName, dateOfBirth);
        if (patients.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(patients);
        }
        return ResponseEntity.ok(patients);
    }

}