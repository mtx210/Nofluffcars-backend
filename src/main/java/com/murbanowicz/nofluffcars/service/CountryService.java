package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Country;
import com.murbanowicz.nofluffcars.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getById(Long id){
        return countryRepository.findById(id).orElse(new Country());
    }
}
