package com.murbanowicz.nofluffcars.data.repository;

import com.murbanowicz.nofluffcars.data.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {


}