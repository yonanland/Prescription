package com.pharma.prescription.repository;

import com.pharma.prescription.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByFullNameAndDateOfBirth(String fullName, LocalDate dateOfBirth);

    @Query("SELECT p FROM Patient p WHERE (:fullName IS NULL OR p.fullName = :fullName) AND (:dateOfBirth IS NULL OR p.dateOfBirth = :dateOfBirth)")
    List<Patient> findByFullNameAndDateOfBirthOptional(@Param("fullName") String fullName, @Param("dateOfBirth") LocalDate dateOfBirth);
}
