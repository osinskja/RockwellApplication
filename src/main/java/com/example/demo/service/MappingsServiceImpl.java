package com.example.demo.service;

import com.example.demo.dto.MappingOutput;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MappingsServiceImpl implements MappingsService {
    private final List<String> mapping1 =
            List.of("Cat", "Mouse", "Dog", "Person", "Monkey", "Gorilla", "Lion", "Tiger", "Puma", "Horse",
                    "Donkey", "Zebra", "Alligator", "Crocodile", "Frog", "Sparrow", "Pigeon", "Eagle", "Hen", "Goat");

    private final List<String> mapping2 =
            List.of("Table", "Spoon", "Chair", "Bed", "Couch", "Mattress", "Pillow", "Door", "TV", "Computer",
                    "Monitor", "Laptop", "Keyboard", "Lamp", "Plate", "Toilet", "Shower", "Window", "Game", "Coin");

    private final List<String> mapping3 =
            List.of("Warsaw", "London", "Budapest", "Washington", "Vienna", "Bucharest", "Lyon", "Paris", "Berlin", "Frankfurt",
                    "York", "Lisbon", "Helsinki", "Stockholm", "Copenhagen", "Tokyo", "Denver", "Rio", "Madrid", "Cracow");

    private final List<String> mapping4 =
            List.of("Football", "Tennis", "Rugby", "Volleyball", "Basketball", "Golf", "Running", "Swimming", "Jumping", "Walking",
                    "Diving", "Flying", "Fighting", "Boxing", "Wrestling", "Handball", "Skiing", "Snowboarding", "Singing", "Fencing");

    private final Map<String, List<String>> mappingsMap = Map.of("mapping1", mapping1, "mapping2",
            mapping2, "mapping3", mapping3, "mapping4", mapping4);

    @Override
    public MappingOutput getMappingOutput(String mappingName, List<Integer> numbers) {
        Map<Integer, List<String>> divisorsMapping = new HashMap<>();
        List<String> mapping = mappingsMap.get(mappingName);
        numbers.forEach(
                i -> divisorsMapping.put(i, getDivisorsMapping(i, mapping))
        );

        return new MappingOutput(divisorsMapping);
    }

    public List<String> getDivisorsMapping(int number, List<String> mapping){
        List<String> divisors = new ArrayList<>();
        divisors.add(mapping.get(0));
        for(int i = 2; i <= number; i++) {
            if(number % i == 0) {
                divisors.add(mapping.get(i-1));
            }
        }
        return divisors;
    }
}
