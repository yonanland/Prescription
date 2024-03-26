package com.pharma.prescription.service;

import com.pharma.prescription.model.Doctor;

public interface IDoctorService {

    Doctor findByEmail(String email);
}
