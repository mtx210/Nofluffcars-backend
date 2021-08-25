package com.murbanowicz.nofluffcars.data.repository;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.dto.ManufacturerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufacturersRepository extends JpaRepository<Manufacturer, Long> {

    Optional<Manufacturer> findByName(String name);

    List<Manufacturer> findByIdCountry(Long IDcountry);

    @Query("select new com.murbanowicz.nofluffcars.dto.ManufacturerDto(M.name, C.name) from Manufacturer M join Country C on M.idCountry = C.id where M.id = ?1")
    List<ManufacturerDto> kek(Long id);
}