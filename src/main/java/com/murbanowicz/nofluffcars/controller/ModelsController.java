package com.murbanowicz.nofluffcars.controller;

import com.murbanowicz.nofluffcars.data.entity.Model;
import com.murbanowicz.nofluffcars.service.ModelsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/models")
public class ModelsController {

    private final ModelsService modelsService;

    public ModelsController(ModelsService modelsService) {
        this.modelsService = modelsService;
    }

    @GetMapping("/manufacturer/{manufacturerId}")
    public ResponseEntity<List<Model>> getByManufacturerId(@PathVariable Long manufacturerId){
        return new ResponseEntity<>(modelsService.getByManufacturerId(manufacturerId), HttpStatus.OK);
    }
}