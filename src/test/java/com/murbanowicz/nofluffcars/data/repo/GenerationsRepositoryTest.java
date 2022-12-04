package com.murbanowicz.nofluffcars.data.repo;

import com.murbanowicz.nofluffcars.data.entity.Generation;
import com.murbanowicz.nofluffcars.api.dto.response.GenerationResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GenerationsRepositoryTest {

    @Autowired
    private GenerationsRepository generationsRepository;

    @Test
    @DisplayName("Should find Generations for a car Model")
    void shouldFindGenerationsForCarModel() {
        //given
        generationsRepository.save(
                new Generation(
                        1,
                        1,
                        "E36",
                        1990,
                        1999,
                        false,true,true,true,true,false,false,true
                ));
        generationsRepository.save(
                new Generation(
                        2,
                        1,
                        "E46",
                        1998,
                        2005,
                        false,true,true,true,true,false,false,true
                ));
        generationsRepository.save(
                new Generation(
                        3,
                        2,
                        "E60",
                        2003,
                        2011,
                        false,true,true,false,false,false,false,false
                ));

        //when
        List<GenerationResponse> generations = generationsRepository.findByModelId(1L);

        //then
        assertNotNull(generations);
        assertEquals(generations.size(), 2);
        assertTrue(generations.stream().anyMatch(generationResponse -> generationResponse.getName().equals("E36")) &&
                generations.stream().anyMatch(generationResponse -> generationResponse.getName().equals("E46")) &&
                generations.stream().noneMatch(generationResponse -> generationResponse.getName().equals("E60")));
    }
}