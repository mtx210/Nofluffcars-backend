package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.repo.GenerationsRepository;
import com.murbanowicz.nofluffcars.dto.response.GenerationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerationsService {

    private final GenerationsRepository generationsRepository;

    public GenerationsService(GenerationsRepository generationsRepository) {
        this.generationsRepository = generationsRepository;
    }

    public List<GenerationResponse> getByModelId(Long modelId) {
        return generationsRepository.findByModelId(modelId);
    }
}