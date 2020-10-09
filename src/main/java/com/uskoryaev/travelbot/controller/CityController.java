package com.uskoryaev.travelbot.controller;

import com.uskoryaev.travelbot.dto.CityDTO;
import com.uskoryaev.travelbot.exception.BadRequestException;
import com.uskoryaev.travelbot.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cities/")
public class CityController {
    private final CityService cityService;

    @GetMapping("{id}")
    public ResponseEntity<CityDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CityDTO> save(CityDTO cityDTO) {
        return ResponseEntity.ok(cityService.save(cityDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<CityDTO> update(@RequestBody CityDTO cityDTO, @PathVariable Long id) {
        if (id.equals(cityDTO.getCityId())) {
            throw new BadRequestException("id miss math");
        }
        return ResponseEntity.ok(cityService.update(cityDTO));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }
}
