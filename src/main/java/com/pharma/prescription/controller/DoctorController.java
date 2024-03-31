package com.pharma.prescription.controller;

import com.pharma.prescription.exception.DoctorNotFoundException;
import com.pharma.prescription.model.Doctor;
import com.pharma.prescription.service.IDoctorService;
import com.pharma.prescription.service.dto.DoctorLoginRequestDTO;
import com.pharma.prescription.service.dto.DoctorLoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final IDoctorService doctorService;

    @Autowired
    public DoctorController(IDoctorService doctorService){
        this.doctorService = doctorService;
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) throws DoctorNotFoundException {
        Doctor doctor = doctorService.findById(id);
        if(doctor != null){
            return ResponseEntity.ok(doctor);
        }
        else {
            throw new DoctorNotFoundException("Doctor not found with id: " + id);
        }
    }

    // Get all doctors
    @GetMapping("/all")
    public ResponseEntity<?> getAllDoctors(){
        return ResponseEntity.ok(doctorService.findAll());
    }

    // Login using email and password and returning a DTO with name and email
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DoctorLoginRequestDTO doctorLoginDTO) throws DoctorNotFoundException {
        // Find the doctor by email in the database
        Doctor doctorInDb = doctorService.findByEmail(doctorLoginDTO.getEmail());

        // Check if the doctor exists and the password matches
        if(doctorInDb != null && doctorInDb.getPassword().equals(doctorLoginDTO.getPassword())){
            return ResponseEntity.ok(new DoctorLoginResponseDTO(doctorInDb.getFirstName(), doctorInDb.getLastName(), doctorInDb.getEmail()));
        }
        else {
            // Authentication failed
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
