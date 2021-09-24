package com.murbanowicz.nofluffcars.controller;

import com.murbanowicz.nofluffcars.dto.response.GenerationResponse;
import com.murbanowicz.nofluffcars.exception.RestApiException;
import com.murbanowicz.nofluffcars.service.GenerationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/generations")
public class GenerationsController {

    private final GenerationsService generationsService;

    public GenerationsController(GenerationsService generationsService) {
        this.generationsService = generationsService;
    }

    @GetMapping("/model/{modelId}")
    public ResponseEntity<List<GenerationResponse>> getByModelId(@PathVariable Long modelId) {
        try {
            return new ResponseEntity<>(generationsService.getByModelId(modelId), HttpStatus.OK);
        } catch (RestApiException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }
}