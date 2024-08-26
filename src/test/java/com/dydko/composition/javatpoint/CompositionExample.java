package com.dydko.composition.javatpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositionExample {
    public static void main(String[] args) {
        List<College> colleges = new ArrayList<>(Arrays.asList(
                new College("ABES Engineering College", "Ghaziabad"),
                new College("AKG Engineering College", "Ghaziabad"),
                new College("ACN College of Engineering & Management Sudies", "Aligarh")));
        University university = new University(colleges);
        university
                .getColleges()
                .stream()
                .forEach(s -> System.out.println(s.getName() + "\t" + s.getAddress()));
    }
}