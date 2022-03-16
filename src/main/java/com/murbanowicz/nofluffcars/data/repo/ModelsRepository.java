package com.murbanowicz.nofluffcars.data.repo;

import com.murbanowicz.nofluffcars.data.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelsRepository extends JpaRepository<Model, Long> {

    List<Model> findByIdManufacturer(Long manufacturerId);
}