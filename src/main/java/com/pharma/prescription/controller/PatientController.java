package com.pharma.prescription.controller;

import com.pharma.prescription.model.Patient;
import com.pharma.prescription.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public ResponseEntity<?> searchPatients(@RequestParam(required = false) String fullName, @RequestParam(required = false) @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate dateOfBirth) {
        if (fullName == null && dateOfBirth == null) {
            return ResponseEntity.badRequest().body("Name and/or dob must be provided");
        }

        List<Patient> results = patientService.searchPatients(fullName, dateOfBirth);
        if (results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(results);
    }

}
