package com.murbanowicz.nofluffcars.controller;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.dto.ManufacturerDto;
import com.murbanowicz.nofluffcars.exception.ApiException;
import com.murbanowicz.nofluffcars.service.ManufacturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/manufacturers")
public class ManufacturersController {

    @Autowired
    private ManufacturersService manufacturersService;

    @GetMapping()
    public List<Manufacturer> getAll(){
        return manufacturersService.getAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ManufacturerDto> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(manufacturersService.getById(id), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

    @GetMapping("/name/{name}")
    public ManufacturerDto getByName(@PathVariable String name){
        return manufacturersService.getByName(name);
    }

    @GetMapping("/country/{countryId}")
    public List<Manufacturer> getByCountry(@PathVariable Long countryId){
        return manufacturersService.getByCountry(countryId);
    }

    @GetMapping("/kek/{id}")
    public List<ManufacturerDto> kek(@PathVariable Long id){
        return manufacturersService.kek(id);
    }
}