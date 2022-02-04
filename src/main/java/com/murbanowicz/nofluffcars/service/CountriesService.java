package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.staticdata.entity.Country;
import com.murbanowicz.nofluffcars.data.staticdata.repo.CountriesRepository;
import org.springframework.stereotype.Service;

@Service
public class CountriesService {

    private final CountriesRepository countriesRepository;

    public CountriesService(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    public Country getById(Long id) {
        return countriesRepository.findById(id).orElse(null);
    }
}
