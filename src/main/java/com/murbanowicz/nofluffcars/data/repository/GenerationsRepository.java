package com.murbanowicz.nofluffcars.data.repository;

import com.murbanowicz.nofluffcars.data.entity.Generation;
import com.murbanowicz.nofluffcars.dto.GenerationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenerationsRepository extends JpaRepository<Generation, Long> {

    List<Generation> findByIdModel(Long id);

    @Query("select new com.murbanowicz.nofluffcars.dto.GenerationDto(G.id, G.name) from Generation G where G.idModel = ?1")
    List<GenerationDto> kek(Long id);
}