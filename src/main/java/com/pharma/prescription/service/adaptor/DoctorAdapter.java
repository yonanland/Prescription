package com.pharma.prescription.service.adaptor;

import com.pharma.prescription.model.Doctor;
import com.pharma.prescription.service.dto.DoctorRequestDTO;
import com.pharma.prescription.service.dto.DoctorResponseDTO;

public class DoctorAdapter {
    public static Doctor toDoctor(DoctorRequestDTO doctorRequestDto){
        return new Doctor(
                null,
                doctorRequestDto.npiNumber(),
                doctorRequestDto.firstName(),
                doctorRequestDto.lastName(),
                doctorRequestDto.specialization(),
                doctorRequestDto.email(),
                doctorRequestDto.phoneNumber(),
                doctorRequestDto.faxNumber(),
                AddressAdapter.toAddress(doctorRequestDto.addressDTO()),
                UserAdapter.toUser(doctorRequestDto.userDTO())
        );
    }

    public static DoctorResponseDTO toDoctorResponseDTO(Doctor doctor) {
        return new DoctorResponseDTO(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getNpi(),
                AddressAdapter.toAddressDTO(doctor.getAddress()),
                doctor.getSpecialization(),
                doctor.getFax(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getUser().getUsername()
        );
    }
}
