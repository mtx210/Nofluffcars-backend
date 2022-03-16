package com.murbanowicz.nofluffcars.data.repo;

import com.murbanowicz.nofluffcars.data.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Long> {


}