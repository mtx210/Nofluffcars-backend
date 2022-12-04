package com.murbanowicz.nofluffcars.data.repo;

import com.murbanowicz.nofluffcars.data.entity.Country;
import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.api.dto.response.ManufacturerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class ManufacturersRepositoryTest {

    @Autowired
    private ManufacturersRepository manufacturersRepository;

    @Autowired
    private CountriesRepository countriesRepository;

    @Test
    void getByName() {
        countriesRepository.save(new Country(1L, "TestCountry"));
        manufacturersRepository.save(new Manufacturer(1L,1L,"BMW"));
        Optional<ManufacturerResponse> manufacturer = manufacturersRepository.getWithName("BMW");


    }
}