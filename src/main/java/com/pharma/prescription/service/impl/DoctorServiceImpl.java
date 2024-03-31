package com.pharma.prescription.service.impl;

import com.pharma.prescription.exception.DoctorNotFoundException;
import com.pharma.prescription.model.Doctor;
import com.pharma.prescription.repository.IDoctorRepository;
import com.pharma.prescription.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements IDoctorService {

    private final IDoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(IDoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor findByEmail(String email) throws DoctorNotFoundException {
        if (email == null) {
            throw new DoctorNotFoundException("Doctor email cannot be null");
        }

        Doctor doctor = doctorRepository.findByEmail(email);
        if (doctor != null) {
            if (doctor.getEmail().equals(email)) {
                return doctor;
            }
            throw new DoctorNotFoundException("Doctor not found with email: " + email);
        }
        throw new DoctorNotFoundException("Doctor not found with email: " + email);
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
