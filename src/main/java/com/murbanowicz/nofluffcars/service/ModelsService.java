package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Model;
import com.murbanowicz.nofluffcars.data.repo.ModelsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelsService {

    private final ModelsRepository modelsRepository;

    public List<Model> getByManufacturerId(Long manufacturerId) {
        return modelsRepository.findByIdManufacturer(manufacturerId);
    }
}