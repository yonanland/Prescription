package com.pharma.prescription.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharma.prescription.model.Address;
import com.pharma.prescription.service.dto.RegistryDoctorDTO;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class NpiRegistryClient {
    @Value("${npi.registry.url}")
    private String NPI_REGISTRY_URL;
    @Value("${npi.registry.version}")
    private String VERSION;
    private final HttpClient httpClient = HttpClient.newHttpClient();
    public RegistryDoctorDTO getRegisteredDoctor(Long npiNumber) {
        val build = HttpRequest.newBuilder()
                .uri(URI.create(NPI_REGISTRY_URL + "?version=" + VERSION +
                        "&number=" + npiNumber))
                .GET()
                .build();
        val objectMapper = new ObjectMapper();
        JsonNode registryResponse = httpClient.sendAsync(build, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(content -> {
                    try {
                        return objectMapper.readTree(content);
                    } catch (JsonProcessingException e) {
                        return null;
                    }
                })
                .join();
        return registryResponse != null ? convertToDTO(registryResponse) : null;
    }

    private RegistryDoctorDTO convertToDTO(JsonNode registryResponse) {
        val result = registryResponse.get("results").get(0);
        return new RegistryDoctorDTO(result.get("basic").get("first_name").asText(),
                result.get("basic").get("last_name").asText(),
                result.get("number").asLong(),
                getAddress(result),
                result.get("taxonomies").get(0).get("desc").asText(),
                result.get("addresses").get(1).get("telephone_number").asText(),
                result.get("addresses").get(1).get("fax_number").asText());
    }

    private Address getAddress(JsonNode result) {
        return new Address(result.get("addresses").get(1).get("address_1").asText(),
                result.get("addresses").get(1).get("city").asText(),
                result.get("addresses").get(1).get("state").asText(),
                result.get("addresses").get(1).get("postal_code").asText());
    }

}
