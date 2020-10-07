package com.uskoryaev.travelbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uskoryaev.travelbot.domain.City;
import com.uskoryaev.travelbot.dto.CityDTO;
import com.uskoryaev.travelbot.exception.CityNotFoundException;
import com.uskoryaev.travelbot.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;
    private final ObjectMapper objectMapper;

    CityDTO findByName(String name) {
        City city = cityRepository.findByName(name).orElseThrow(() -> new CityNotFoundException(name));
        return objectMapper.convertValue(city, CityDTO.class);
    }
}
