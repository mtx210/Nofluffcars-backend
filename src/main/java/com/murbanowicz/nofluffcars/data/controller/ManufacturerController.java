package com.murbanowicz.nofluffcars.data.controller;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.data.repository.ManufacturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ManufacturerController {

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    @GetMapping("/manufacturer")
    public Iterable<Manufacturer> getAllManufacturer(){
        return manufacturerRepo.findAll();
    }
}