package com.pharma.prescription.controller;

import com.pharma.prescription.model.Doctor;
import com.pharma.prescription.service.IDoctorService;
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Doctor doctor){
        // Find the doctor by email in the database
        Doctor doctorInDb = doctorService.findByEmail(doctor.getEmail());
        System.out.println(doctorInDb);
        System.out.println();
        System.out.println(doctor.getPassword());
        System.out.println(doctor.getEmail());

        // Check if the doctor exists and the password matches
        if(doctorInDb != null && doctorInDb.getPassword().equals(doctor.getPassword())){
            return ResponseEntity.ok(doctorInDb);
        }
        else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
