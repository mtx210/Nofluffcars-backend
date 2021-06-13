package com.murbanowicz.nofluffcars.data.repository;

import com.murbanowicz.nofluffcars.data.entity.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepo extends CrudRepository<Manufacturer, Long> {
}