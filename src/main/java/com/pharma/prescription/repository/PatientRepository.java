package com.pharma.prescription.repository;

import com.pharma.prescription.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAndDateOfBirth(String firstName, String lastName, LocalDate dateOfBirth);

//    @Query("SELECT p FROM Patient p WHERE " +
//            "(:firstName IS NULL OR LOWER(p.firstName) = LOWER(:firstName)) AND " +
//            "(:lastName IS NULL OR LOWER(p.lastName) = LOWER(:lastName)) AND " +
//            "(:dateOfBirth IS NULL OR p.dateOfBirth = :dateOfBirth)")
//    List<Patient> findByFirstNameAndLastNameAndDateOfBirthOptional(
//            @Param("firstName") String firstName,
//            @Param("lastName") String lastName,
//            @Param("dateOfBirth") LocalDate dateOfBirth);

    @Query(value = "SELECT * FROM patient WHERE " +
            "(COALESCE(:firstName, '') = '' OR LOWER(first_name) = LOWER(:firstName)) AND " +
            "(COALESCE(:lastName, '') = '' OR LOWER(last_name) = LOWER(:lastName)) AND " +
            "(CAST(:dateOfBirth AS text) IS NULL OR date_of_birth = :dateOfBirth)",
            nativeQuery = true)
    List<Patient> findByFirstNameAndLastNameAndDateOfBirthOptional(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("dateOfBirth") LocalDate dateOfBirth);


}
