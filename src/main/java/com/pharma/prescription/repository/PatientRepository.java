package com.pharma.prescription.repository;

import com.pharma.prescription.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, LocalDate dateOfBirth);

    @Query("SELECT p FROM Patient p WHERE " +
            "(:firstName IS NULL OR p.firstName = :firstName) AND " +
            "(:lastName IS NULL OR p.lastName = :lastName) AND " +
            "(:dateOfBirth IS NULL OR p.dateOfBirth = :dateOfBirth)")
    List<Patient> findByFirstNameAndLastNameAndDateOfBirthOptional(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("dateOfBirth") LocalDate dateOfBirth);
}
