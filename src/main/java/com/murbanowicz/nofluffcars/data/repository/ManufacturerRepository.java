package com.murbanowicz.nofluffcars.data.repository;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    Optional<Manufacturer> findByName(String name);

    List<Manufacturer> findByIdCountry(Long IDcountry);
}