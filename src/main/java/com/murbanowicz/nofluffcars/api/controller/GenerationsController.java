package com.murbanowicz.nofluffcars.api.controller;

import com.murbanowicz.nofluffcars.api.dto.response.GenerationResponse;
import com.murbanowicz.nofluffcars.service.GenerationsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/generations")
@AllArgsConstructor
public class GenerationsController {

    private final GenerationsService generationsService;

    @GetMapping("/model/{modelId}")
    public ResponseEntity<List<GenerationResponse>> getByModelId(
            @PathVariable Long modelId
    ) {
        return new ResponseEntity<>(generationsService.getByModelId(modelId), HttpStatus.OK);
    }
}