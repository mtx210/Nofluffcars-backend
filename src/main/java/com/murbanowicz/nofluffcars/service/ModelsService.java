package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.staticdata.entity.Model;
import com.murbanowicz.nofluffcars.data.staticdata.repo.ModelsRepository;
import com.murbanowicz.nofluffcars.exception.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelsService {

    private final ModelsRepository modelsRepository;

    public ModelsService(ModelsRepository modelsRepository) {
        this.modelsRepository = modelsRepository;
    }

    public List<Model> getByManufacturerId(Long manufacturerId) throws RestApiException {
        return modelsRepository.findByIdManufacturer(manufacturerId);
    }
}