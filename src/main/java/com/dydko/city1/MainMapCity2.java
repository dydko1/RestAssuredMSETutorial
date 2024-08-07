package com.dydko.city1;

import java.util.stream.Collectors;

import static com.dydko.city1.TemperatureFactory.prepareTemperature;

public class MainMapCity2 {
    public static void main(String[] args) {
        System.out.println(prepareTemperature()
                .stream()
                .filter(c -> c.getTemperature() > 10)
                .collect(Collectors.toMap(
                        City1::getName,
                        City1::getTemperature,
                        (k, i) -> k)));
        //System.out.println(l);
    }
}
