package com.example.demo;

import com.example.demo.dto.MappingOutput;
import com.example.demo.service.MappingsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RockwellApplicationTests {

    @Autowired
    private MappingsService mappingsService;

    @Test
    void getMappingOutputWithThreeNumbers() {
        MappingOutput mappingOutput = mappingsService.getMappingOutput("mapping1", List.of(1, 2, 3));

        MappingOutput mappingOutputExpected = new MappingOutput(Map.of(1, List.of("Cat"), 2, List.of("Cat", "Mouse"), 3, List.of("Cat", "Dog")));
        assertEquals(mappingOutputExpected.getOutput(), mappingOutput.getOutput());
    }

    @Test
    void getMappingOutputWithFiveNumbers() {
        MappingOutput mappingOutput = mappingsService.getMappingOutput("mapping3", List.of(1, 2, 3, 7, 20));

        MappingOutput mappingOutputExpected = new MappingOutput(Map.of(1, List.of("Warsaw"), 2, List.of("Warsaw", "London"),
				3, List.of("Warsaw", "Budapest"), 7, List.of("Warsaw", "Lyon"),
				20, List.of("Warsaw", "London", "Washington", "Vienna", "Frankfurt", "Cracow")));
        assertEquals(mappingOutputExpected.getOutput(), mappingOutput.getOutput());
    }

}
