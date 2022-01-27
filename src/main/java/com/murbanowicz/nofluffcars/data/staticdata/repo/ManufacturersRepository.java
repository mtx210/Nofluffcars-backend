package com.murbanowicz.nofluffcars.data.staticdata.repo;

import com.murbanowicz.nofluffcars.data.staticdata.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufacturersRepository extends JpaRepository<Manufacturer, Long> {

    Optional<Manufacturer> findByName(String name);

    List<Manufacturer> findByIdCountry(Long IDcountry);
}