package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.staticdata.repo.GenerationsRepository;
import com.murbanowicz.nofluffcars.dto.response.GenerationResponse;
import com.murbanowicz.nofluffcars.exception.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerationsService {

    private final GenerationsRepository generationsRepository;

    public GenerationsService(GenerationsRepository generationsRepository) {
        this.generationsRepository = generationsRepository;
    }

    public List<GenerationResponse> getByModelId(Long modelId) throws RestApiException {
        return generationsRepository.findByModelId(modelId);
    }
}