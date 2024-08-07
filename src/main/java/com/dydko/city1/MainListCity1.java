package com.dydko.city1;

import java.util.List;
import java.util.stream.Collectors;

import static com.dydko.city1.TemperatureFactory.prepareTemperature;

public class MainListCity1 {

    public static void main(String[] args) {
        List<String> s = prepareTemperature()
                .stream()
                .filter(f -> f.getTemperature() > 0)
                .map(f -> f.getName())
                .collect(Collectors.toList());
        System.out.println(s);
    }


}