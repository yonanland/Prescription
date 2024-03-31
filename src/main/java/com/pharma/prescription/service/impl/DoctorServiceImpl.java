package com.pharma.prescription.service.impl;

import com.pharma.prescription.model.Doctor;
import com.pharma.prescription.repository.IDoctorRepository;
import com.pharma.prescription.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {

    private final IDoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(IDoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor findByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
