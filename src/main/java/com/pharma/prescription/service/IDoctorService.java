package com.pharma.prescription.service;

import com.pharma.prescription.exception.DoctorNotFoundException;
import com.pharma.prescription.model.Doctor;

import java.util.List;

public interface IDoctorService {
    Doctor findByEmail(String email) throws DoctorNotFoundException;
    Doctor findById(Long id);
    List<Doctor> findAll();
}
