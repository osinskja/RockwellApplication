package com.example.demo.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
public class MappingOutput implements Serializable {

    private final Map<Integer, List<String>> output;

    public MappingOutput(Map<Integer, List<String>> output) {
        this.output = output;
    }
}
