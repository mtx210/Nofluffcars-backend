package com.murbanowicz.nofluffcars.controller;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.dto.ManufacturerDto;
import com.murbanowicz.nofluffcars.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping()
    public List<Manufacturer> getAll(){
        return manufacturerService.getAll();
    }

    @GetMapping("/id/{id}")
    public ManufacturerDto getById(@PathVariable Long id){
        Manufacturer manufacturer = manufacturerService.getById(id);
        return new ManufacturerDto(manufacturer.getID(), manufacturer.getName());
    }

    @GetMapping("/name/{name}")
    public ManufacturerDto getByName(@PathVariable String name){
        Manufacturer manufacturer = manufacturerService.getByName(name);
        return new ManufacturerDto(manufacturer.getID(), manufacturer.getName());
    }
}