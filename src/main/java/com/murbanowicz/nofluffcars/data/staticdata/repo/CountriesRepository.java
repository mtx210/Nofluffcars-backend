package com.murbanowicz.nofluffcars.data.staticdata.repo;

import com.murbanowicz.nofluffcars.data.staticdata.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Long> {


}