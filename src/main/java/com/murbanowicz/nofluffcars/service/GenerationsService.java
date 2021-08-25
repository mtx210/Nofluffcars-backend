package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Generation;
import com.murbanowicz.nofluffcars.data.repository.GenerationsRepository;
import com.murbanowicz.nofluffcars.dto.GenerationDto;
import com.murbanowicz.nofluffcars.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerationsService {

    @Autowired
    private GenerationsRepository generationsRepository;

    public List<GenerationDto> getByModelId(Long modelId) throws ApiException {
        List<GenerationDto> generationList = generationsRepository.kek(modelId);
        if(!generationList.isEmpty()){
            return generationList;
        } else {
            throw new ApiException(HttpStatus.NOT_FOUND);
        }
    }
}