package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.data.repository.ManufacturerRepository;
import com.murbanowicz.nofluffcars.dto.ManufacturerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CountryService countryService;

    public List<Manufacturer> getAll(){
        return manufacturerRepository.findAll();
    }

    public ManufacturerDto getById(Long id){
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElse(new Manufacturer());
        String countryName = countryService.getById(manufacturer.getIdCountry()).getName();
        return new ManufacturerDto(manufacturer.getName(), countryName);
    }

    public ManufacturerDto getByName(String name){
        Manufacturer manufacturer = manufacturerRepository.findByName(name).orElse(new Manufacturer());
        String countryName = countryService.getById(manufacturer.getIdCountry()).getName();
        return new ManufacturerDto(manufacturer.getName(), countryName);
    }

    public List<Manufacturer> getByCountry(Long countryId){
        return manufacturerRepository.findByIdCountry(countryId);
    }
}