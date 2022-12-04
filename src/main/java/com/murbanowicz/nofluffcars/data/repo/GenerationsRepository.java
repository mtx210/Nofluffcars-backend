package com.murbanowicz.nofluffcars.data.repo;

import com.murbanowicz.nofluffcars.api.dto.response.GenerationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.murbanowicz.nofluffcars.data.entity.Generation;

import java.util.List;

@Repository
public interface GenerationsRepository extends JpaRepository<Generation, Long> {

    @Query("SELECT new com.murbanowicz.nofluffcars.api.dto.response.GenerationResponse(G.id, G.name) " +
            "FROM Generation G " +
            "WHERE G.idModel = :id")
    List<GenerationResponse> findByModelId(Long id);
}