package com.dydko.city1;

import java.util.stream.Collectors;

import static com.dydko.city1.TemperatureFactory.prepareTemperature;

public class MainCollectors {
    public static void main(String[] args) {
        System.out.println(
                prepareTemperature()
                        .stream()
                        .collect(Collectors.groupingBy(
                                City1::getName, Collectors.counting()
                        ))
        );
    }
}