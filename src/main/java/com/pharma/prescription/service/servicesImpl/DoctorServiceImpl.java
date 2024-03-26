package com.pharma.prescription.service.servicesImpl;

import com.pharma.prescription.exceptions.DoctorCreationException;
import com.pharma.prescription.model.Role;
import com.pharma.prescription.repository.DoctorRepository;
import com.pharma.prescription.service.DoctorService;
import com.pharma.prescription.service.adaptor.DoctorAdapter;
import com.pharma.prescription.service.dto.DoctorRequestDTO;
import com.pharma.prescription.service.dto.DoctorResponseDTO;
import com.pharma.prescription.service.dto.RegistryDoctorDTO;
import com.pharma.prescription.service.util.NpiRegistryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final NpiRegistryClient npiRegistryClient;
    private final PasswordEncoder bcryptPasswordEncoder;
    @Override
    public RegistryDoctorDTO searchByNPINumber(Long npiNumber) {
        if (existsInDB(npiNumber))
            throw new DoctorCreationException("Doctor with NPI number " + npiNumber + " already exists in the database." +
                    " Please search with a different NPI number or login.");
        var doctorInfo = npiRegistryClient.getRegisteredDoctor(npiNumber);
        if (doctorInfo == null) {
            throw new DoctorCreationException("No matching records found");
        }
        return doctorInfo;
    }

    private boolean existsInDB(Long npiNumber) {
        return doctorRepository.existsById(npiNumber);
    }

    @Override
    public DoctorResponseDTO signUp(DoctorRequestDTO doctorRequestDTO) {
        var doctor = DoctorAdapter.toDoctor(doctorRequestDTO);
        if(doctorRepository.findByEmail(doctor.getEmail()) != null){
            throw new DoctorCreationException("Email already in use. Please use a different email");
        }
        doctor.getUser().setRole(Role.DOCTOR);
        doctor.getUser().setPassword(bcryptPasswordEncoder.encode(doctor.getUser().getPassword()));
        return DoctorAdapter.toDoctorResponseDTO(doctorRepository.save(doctor));
    }
    
}
