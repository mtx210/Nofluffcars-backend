package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.data.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAll(){
        return manufacturerRepository.findAll();
    }

    public Manufacturer getById(Long id){
        return manufacturerRepository.getById(id);
    }

    public Manufacturer getByName(String name){
        return manufacturerRepository.findByName(name);
    }
}