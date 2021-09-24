package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.entity.Country;
import com.murbanowicz.nofluffcars.data.repository.CountriesRepository;
import com.murbanowicz.nofluffcars.exception.RestApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CountriesService {

    private final CountriesRepository countriesRepository;

    public CountriesService(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    public Country getById(Long id) throws RestApiException {
        if(id == null){
            throw new RestApiException(HttpStatus.BAD_REQUEST);
        }

        Country country = countriesRepository.findById(id).orElse(null);
        if(country == null){
            throw new RestApiException(HttpStatus.NO_CONTENT);
        }

        return country;
    }
}
