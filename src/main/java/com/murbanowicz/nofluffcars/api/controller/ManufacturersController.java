package com.murbanowicz.nofluffcars.api.controller;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.api.dto.response.ManufacturerResponse;
import com.murbanowicz.nofluffcars.service.ManufacturersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/manufacturers")
@AllArgsConstructor
public class ManufacturersController {

    private final ManufacturersService manufacturersService;

    @GetMapping()
    public ResponseEntity<List<Manufacturer>> getAll(){
        return new ResponseEntity<>(manufacturersService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ManufacturerResponse> getById(
            @PathVariable long id
    ){
        return new ResponseEntity<>(manufacturersService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ManufacturerResponse> getByName(
            @PathVariable String name
    ){
        return new ResponseEntity<>(manufacturersService.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/countryId/{countryId}")
    public ResponseEntity<List<ManufacturerResponse>> getByCountryId(
            @PathVariable long countryId
    ){
        return new ResponseEntity<>(manufacturersService.getByCountryId(countryId), HttpStatus.OK);
    }
}