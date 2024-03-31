package com.pharma.prescription.controller;

import com.pharma.prescription.dto.PatientDTO;
import com.pharma.prescription.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    // @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<PatientDTO> createPatientProfile(@Valid @RequestBody PatientDTO patientDTO) throws Exception {
        PatientDTO savedPatientDTO = patientService.createPatient(patientDTO);
        return ResponseEntity.ok(savedPatientDTO);
    }

    @GetMapping("/search")
    // @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<List<PatientDTO>> searchPatients(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirth) {


        List<PatientDTO> patientsDTO = patientService.searchPatients(firstName, lastName, dateOfBirth);
        if (patientsDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(patientsDTO);
    }
}
