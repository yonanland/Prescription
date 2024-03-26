package com.pharma.prescription.controller;

import com.pharma.prescription.exceptions.DoctorCreationException;
import com.pharma.prescription.service.DoctorService;
import com.pharma.prescription.service.dto.DoctorRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody DoctorRequestDTO doctorRequestDTO) {
        return ResponseEntity.ok(doctorService.signUp(doctorRequestDTO));
    }
}
