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
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CityDTO findByName(String name) {
        City city = cityRepository.findByName(name)
                .orElseThrow(() -> new CityNotFoundException(name));
        return objectMapper.convertValue(city, CityDTO.class);
    }

    public CityDTO findById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(String.valueOf(id)));
        return objectMapper.convertValue(city, CityDTO.class);
    }

    public CityDTO save(CityDTO cityDTO) {
        City city = objectMapper.convertValue(cityDTO, City.class);
        return objectMapper.convertValue(cityRepository.save(city), CityDTO.class);
    }

    public CityDTO update(CityDTO cityDTO) {
        City city = cityRepository.findById(cityDTO.getCityId())
                .orElseThrow(() -> new CityNotFoundException(String.valueOf(cityDTO.getCityId())));
        return objectMapper.convertValue(cityRepository.save(city), CityDTO.class);
    }

    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}