package com.dydko.city1;

import java.util.Set;
import java.util.stream.Collectors;

import static com.dydko.city1.TemperatureFactory.prepareTemperature;

public class MainSetCity1 {
    public static void main(String[] args) {

        Set<String> stringSet = prepareTemperature()
                .stream()
                .filter(f -> f.getTemperature() > 10)
                .map(f -> f.getName())
                .collect(Collectors.toSet());
        System.out.println(stringSet);
    }
}