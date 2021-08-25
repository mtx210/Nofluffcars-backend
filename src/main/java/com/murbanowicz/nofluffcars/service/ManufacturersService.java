package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.data.repository.ManufacturersRepository;
import com.murbanowicz.nofluffcars.dto.ManufacturerDto;
import com.murbanowicz.nofluffcars.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturersService {

    @Autowired
    private ManufacturersRepository manufacturersRepository;

    @Autowired
    private CountriesService countriesService;

    public List<Manufacturer> getAll(){
        return manufacturersRepository.findAll();
    }

    public ManufacturerDto getById(Long id) throws ApiException {
        Manufacturer manufacturer = manufacturersRepository.findById(id).orElse(null);
        if(manufacturer != null){
            String countryName = countriesService.getById(manufacturer.getIdCountry()).getName();
            return new ManufacturerDto(manufacturer.getName(), countryName);
        } else {
            throw new ApiException(HttpStatus.NOT_FOUND);
        }
    }

    public ManufacturerDto getByName(String name){
        Manufacturer manufacturer = manufacturersRepository.findByName(name).orElse(new Manufacturer());
        String countryName = countriesService.getById(manufacturer.getIdCountry()).getName();
        return new ManufacturerDto(manufacturer.getName(), countryName);
    }

    public List<Manufacturer> getByCountry(Long countryId){
        return manufacturersRepository.findByIdCountry(countryId);
    }

    public List<ManufacturerDto> kek(Long id) {
        return manufacturersRepository.kek(id);
    }
}