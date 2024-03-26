package com.pharma.prescription.repository;

import com.pharma.prescription.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByEmail(String email);
}
