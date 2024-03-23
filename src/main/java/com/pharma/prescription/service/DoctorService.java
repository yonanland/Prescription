package com.pharma.prescription.service;

import com.pharma.prescription.model.Doctor;
import com.pharma.prescription.service.dto.RegistryDoctorDTO;

public interface DoctorService {
    RegistryDoctorDTO searchByNPINumber(Long npiNumber);

}
