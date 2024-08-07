package com.dydko.city1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.dydko.city1.TemperatureFactory.prepareTemperature;

public class MainGroupingBy {
    public static void main(String[] args) {
        Map<String, List<City1>> c1 = prepareTemperature()
                .stream()
                .collect(Collectors.groupingBy(City1::getName));
    }
}
