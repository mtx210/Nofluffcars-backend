package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.data.repo.ManufacturersRepository;
import com.murbanowicz.nofluffcars.dto.response.ManufacturerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturersService {

    private final ManufacturersRepository manufacturersRepository;

    public ManufacturersService(ManufacturersRepository manufacturersRepository) {
        this.manufacturersRepository = manufacturersRepository;
    }

    public List<Manufacturer> getAll() {
        return manufacturersRepository.findAll();
    }

    public ManufacturerResponse getById(long id) {
        return manufacturersRepository.getWithId(id).orElse(new ManufacturerResponse());
    }

    public ManufacturerResponse getByName(String name) {
        return manufacturersRepository.getWithName(name).orElse(new ManufacturerResponse());
    }

    public List<ManufacturerResponse> getByCountryId(Long countryId) {
        return manufacturersRepository.getWithCountryId(countryId);
    }
}