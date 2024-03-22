package com.pharma.prescription.controller;

import com.pharma.prescription.exceptions.DoctorCreationException;
import com.pharma.prescription.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;
    @GetMapping("/search-npi")
    public ResponseEntity<?> searchByNPI(@RequestParam Long number) {
        try {
           return ResponseEntity.ok(doctorService.searchByNPINumber(number));
        }
        catch (DoctorCreationException dce){
            return ResponseEntity.badRequest().body(dce.getMessage());
        }
    }
}
