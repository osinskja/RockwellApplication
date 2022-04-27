package com.example.demo.controller;

import com.example.demo.service.MappingsService;
import com.example.demo.dto.MappingOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MappingController {

    @Autowired
    private MappingsService mappingsService;

    @GetMapping("/mappings")
    public MappingOutput getMappingOutput(@RequestParam String mappingname, @RequestParam List<Integer> numbers) {

        return mappingsService.getMappingOutput(mappingname, numbers);
    }
}
