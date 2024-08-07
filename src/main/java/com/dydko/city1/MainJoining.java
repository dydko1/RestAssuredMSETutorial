package com.dydko.city1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.dydko.city1.TemperatureFactory.prepareTemperature;

public class MainJoining {
    public static void main(String[] args) {
        List<String> x1 = prepareTemperature()
                .stream()
                .filter(cityTemp -> cityTemp.getTemperature() > 10)
                .map(f -> f.getName())
                .collect(Collectors.toList());
        System.out.println(x1);
    }
}
