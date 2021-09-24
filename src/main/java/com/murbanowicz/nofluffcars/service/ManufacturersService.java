package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.data.repository.ManufacturersRepository;
import com.murbanowicz.nofluffcars.dto.response.ManufacturerResponse;
import com.murbanowicz.nofluffcars.exception.RestApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturersService {

    private final ManufacturersRepository manufacturersRepository;
    private final CountriesService countriesService;

    public ManufacturersService(ManufacturersRepository manufacturersRepository, CountriesService countriesService) {
        this.manufacturersRepository = manufacturersRepository;
        this.countriesService = countriesService;
    }

    public List<Manufacturer> getAll() throws RestApiException {
        List<Manufacturer> manufacturers = manufacturersRepository.findAll();
        if(manufacturers.isEmpty()){
            throw new RestApiException(HttpStatus.NO_CONTENT);
        }

        return manufacturers;
    }

    public ManufacturerResponse getById(Long id) throws RestApiException {
        if(id == null){
            throw new RestApiException(HttpStatus.BAD_REQUEST);
        }

        Manufacturer manufacturer = manufacturersRepository.findById(id).orElse(null);
        if(manufacturer == null){
            throw new RestApiException(HttpStatus.NO_CONTENT);
        }

        String countryName = countriesService.getById(manufacturer.getIdCountry()).getName();
        return new ManufacturerResponse(manufacturer.getName(), countryName);
    }

    public ManufacturerResponse getByName(String name) throws RestApiException {
        if(name == null || name.isEmpty()){
            throw new RestApiException(HttpStatus.BAD_REQUEST);
        }

        Manufacturer manufacturer = manufacturersRepository.findByName(name).orElse(null);
        if(manufacturer == null){
            throw new RestApiException(HttpStatus.NO_CONTENT);
        }

        String countryName = countriesService.getById(manufacturer.getIdCountry()).getName();
        return new ManufacturerResponse(manufacturer.getName(), countryName);
    }

    public List<Manufacturer> getByCountry(Long countryId) throws RestApiException {
        if(countryId == null){
            throw new RestApiException(HttpStatus.BAD_REQUEST);
        }

        List<Manufacturer> manufacturers = manufacturersRepository.findByIdCountry(countryId);
        if(manufacturers.isEmpty()){
            throw new RestApiException(HttpStatus.NO_CONTENT);
        }

        return manufacturers;
    }
}