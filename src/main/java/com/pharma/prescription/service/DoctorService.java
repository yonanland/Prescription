package com.pharma.prescription.service;

import com.pharma.prescription.service.dto.DoctorRequestDTO;
import com.pharma.prescription.service.dto.DoctorResponseDTO;
import com.pharma.prescription.service.dto.RegistryDoctorDTO;

public interface DoctorService {
    RegistryDoctorDTO searchByNPINumber(Long npiNumber);
    DoctorResponseDTO signUp(DoctorRequestDTO doctorRequestDTO);

}
