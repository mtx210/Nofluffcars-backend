package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.repo.GenerationsRepository;
import com.murbanowicz.nofluffcars.api.dto.response.GenerationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenerationsService {

    private final GenerationsRepository generationsRepository;

    public List<GenerationResponse> getByModelId(Long modelId) {
        return generationsRepository.findByModelId(modelId);
    }
}