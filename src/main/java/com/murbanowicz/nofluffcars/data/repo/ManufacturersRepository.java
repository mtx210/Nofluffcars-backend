package com.murbanowicz.nofluffcars.data.repo;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import com.murbanowicz.nofluffcars.dto.response.ManufacturerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufacturersRepository extends JpaRepository<Manufacturer, Long> {

    @Query("SELECT new com.murbanowicz.nofluffcars.dto.response.ManufacturerResponse(M.name, C.name) " +
            "FROM Manufacturer M " +
            "JOIN Country C ON M.idCountry = C.id " +
            "WHERE M.id = :id")
    Optional<ManufacturerResponse> getWithId(long id);

    @Query("SELECT new com.murbanowicz.nofluffcars.dto.response.ManufacturerResponse(M.name, C.name) " +
            "FROM Manufacturer M " +
            "JOIN Country C ON M.idCountry = C.id " +
            "WHERE M.name = :name")
    Optional<ManufacturerResponse> getWithName(String name);

    @Query("SELECT new com.murbanowicz.nofluffcars.dto.response.ManufacturerResponse(M.name, C.name) " +
            "FROM Manufacturer M " +
            "JOIN Country C ON M.idCountry = C.id " +
            "WHERE C.id = :id")
    List<ManufacturerResponse> getWithCountryId(long id);
}