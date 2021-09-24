package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Model;
import com.murbanowicz.nofluffcars.data.repository.ModelsRepository;
import com.murbanowicz.nofluffcars.exception.RestApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelsService {

    private final ModelsRepository modelsRepository;

    public ModelsService(ModelsRepository modelsRepository) {
        this.modelsRepository = modelsRepository;
    }

    public List<Model> getByManufacturerId(Long manufacturerId) throws RestApiException {
        if(manufacturerId == null){
            throw new RestApiException(HttpStatus.BAD_REQUEST);
        }

        List<Model> modelList = modelsRepository.findByIdManufacturer(manufacturerId);
        if(modelList.isEmpty()){
            throw new RestApiException(HttpStatus.NO_CONTENT);
        }

        return modelList;
    }
}