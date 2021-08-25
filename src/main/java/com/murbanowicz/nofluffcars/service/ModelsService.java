package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Model;
import com.murbanowicz.nofluffcars.data.repository.ModelsRepository;
import com.murbanowicz.nofluffcars.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelsService {

    @Autowired
    private ModelsRepository modelsRepository;

    public List<Model> getByManufacturerId(Long manufacturerId) throws ApiException {
        List<Model> modelList = modelsRepository.findByIdManufacturer(manufacturerId);
        if(!modelList.isEmpty()){
            return modelList;
        } else {
            throw new ApiException(HttpStatus.NOT_FOUND);
        }
    }
}