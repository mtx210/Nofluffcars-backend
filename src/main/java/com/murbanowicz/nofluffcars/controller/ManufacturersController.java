package com.murbanowicz.nofluffcars.controller;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.dto.response.ManufacturerResponse;
import com.murbanowicz.nofluffcars.exception.RestApiException;
import com.murbanowicz.nofluffcars.service.ManufacturersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/manufacturers")
public class ManufacturersController {

    private final ManufacturersService manufacturersService;

    public ManufacturersController(ManufacturersService manufacturersService) {
        this.manufacturersService = manufacturersService;
    }

    @GetMapping()
    public ResponseEntity<List<Manufacturer>> getAll(){
        return new ResponseEntity<>(manufacturersService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ManufacturerResponse> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(manufacturersService.getById(id), HttpStatus.OK);
        } catch (RestApiException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ManufacturerResponse> getByName(@PathVariable String name){
        try {
            return new ResponseEntity<>(manufacturersService.getByName(name), HttpStatus.OK);
        } catch (RestApiException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<Manufacturer>> getByCountry(@PathVariable Long countryId){
        try {
            return new ResponseEntity<>(manufacturersService.getByCountry(countryId), HttpStatus.OK);
        } catch (RestApiException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }
}