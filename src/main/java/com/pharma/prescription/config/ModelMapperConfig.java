package com.pharma.prescription.config;

import com.pharma.prescription.dto.AddressDTO;
import com.pharma.prescription.model.Address;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Address.class, AddressDTO.class)
                .addMapping(Address::getAddress_id, AddressDTO::setAddressId);
        return modelMapper;
    }
}