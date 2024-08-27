package com.dydko.simplilearn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams0004 {

    @Test
    void test123() {
        List<String> names = Arrays.asList("Mike", "David", "", "John", "Jane", "Charlie", "Alan", "", "Joanna", "");

        List<String> listFilteredNames = names
                .stream()
                .filter(n -> !n.isEmpty())
                .collect(Collectors.toList());
        System.out.println(listFilteredNames);

        String listFilteredNames2 = names
                .stream()
                .filter(n -> !n.isEmpty())
                .collect(Collectors.joining(","));
        System.out.println(listFilteredNames2);

    }
}