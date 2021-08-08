package com.murbanowicz.nofluffcars.controller;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.dto.ManufacturerDto;
import com.murbanowicz.nofluffcars.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping()
    public List<Manufacturer> getAll(){
        return manufacturerService.getAll();
    }

    @GetMapping("/id/{id}")
    public ManufacturerDto getById(@PathVariable Long id){
        return manufacturerService.getById(id);
    }

    @GetMapping("/name/{name}")
    public ManufacturerDto getByName(@PathVariable String name){
        return manufacturerService.getByName(name);
    }

    @GetMapping("/country/{countryId}")
    public List<Manufacturer> getByCountry(@PathVariable Long countryId){
        return manufacturerService.getByCountry(countryId);
    }
}