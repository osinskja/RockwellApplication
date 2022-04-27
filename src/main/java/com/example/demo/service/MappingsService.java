package com.example.demo.service;

import com.example.demo.dto.MappingOutput;

import java.util.List;

public interface MappingsService {

    MappingOutput getMappingOutput(String mappingName, List<Integer> numbers);
}
