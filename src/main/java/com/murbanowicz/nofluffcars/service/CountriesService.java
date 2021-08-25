package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Country;
import com.murbanowicz.nofluffcars.data.repository.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountriesService {

    @Autowired
    private CountriesRepository countriesRepository;

    public Country getById(Long id){
        return countriesRepository.findById(id).orElse(new Country());
    }
}
