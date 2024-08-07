package com.dydko.city1;

import java.util.ArrayList;
import java.util.List;

public class TemperatureFactory {
    public static List<City1> prepareTemperature() {
        List<City1> cities = new ArrayList<>();
        cities.add(new City1("New Delhi", 33.5));
        cities.add(new City1("Mexico", 14));
        cities.add(new City1("New York", 13));
        cities.add(new City1("Dubai", 43));
        cities.add(new City1("London", 15));
        cities.add(new City1("Alaska", 1));
        cities.add(new City1("Kolkata", 30));
        cities.add(new City1("Sydney", 11));
        cities.add(new City1("Mexico", 1412));
        cities.add(new City1("Dubai", 43));
        return cities;
    }
}
