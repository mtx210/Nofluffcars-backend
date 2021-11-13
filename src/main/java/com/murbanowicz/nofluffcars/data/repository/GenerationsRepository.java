package com.murbanowicz.nofluffcars.data.repository;

import com.murbanowicz.nofluffcars.data.entity.Generation;
import com.murbanowicz.nofluffcars.dto.response.GenerationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenerationsRepository extends JpaRepository<Generation, Long> {

    @Query("SELECT new com.murbanowicz.nofluffcars.dto.response.GenerationResponse(G.id, G.name) " +
            "FROM Generation G " +
            "WHERE G.idModel = :id")
    List<GenerationResponse> getGenerationsByModelId(Long id);
}