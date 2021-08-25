package com.murbanowicz.nofluffcars.controller;

import com.murbanowicz.nofluffcars.data.entity.Generation;
import com.murbanowicz.nofluffcars.dto.GenerationDto;
import com.murbanowicz.nofluffcars.exception.ApiException;
import com.murbanowicz.nofluffcars.service.GenerationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/generations")
public class GenerationsController {

    @Autowired
    private GenerationsService generationsService;

    @GetMapping("/bymodel/{modelId}")
    public ResponseEntity<List<GenerationDto>> getByModelId(@PathVariable Long modelId) {
        try {
            return new ResponseEntity<>(generationsService.getByModelId(modelId), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }
}