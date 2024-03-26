package com.pharma.prescription;

import com.pharma.prescription.model.Address;
import com.pharma.prescription.model.Patient;
import com.pharma.prescription.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        generatePatientsData();
    }

    private void generatePatientsData() {
        Patient patient1 = new Patient();
        patient1.setFullName("John Doe");
        patient1.setDateOfBirth(LocalDate.parse("01/15/1985", DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        patient1.setPhoneNumber("1234567890");
        patient1.setInsurance("Premium Health Insurance");

        Address address1 = new Address();
        address1.setStreet("123 Main St");
        address1.setCity("Anytown");
        address1.setState("Anystate");
        address1.setZip("12345");

        patient1.setAddress(address1);

        patientRepository.save(patient1);

    }
}
