package com.dydko.city1;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.dydko.city1.TemperatureFactory.prepareTemperature;

public class MainJoining2 {
    public static void main(String[] args) {
        String s1 = prepareTemperature()
                .stream()
                .filter(city1 -> city1.getTemperature() > 10)
                .map(f1 -> f1.getName())
                .collect(Collectors.joining("xx", "Prefix:", ":Suffix"));
        System.out.println(s1);
    }
}
