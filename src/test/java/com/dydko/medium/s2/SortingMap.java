package com.dydko.medium.s2;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingMap {

    @Test
    void sortingMap() {
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 85);
        studentScores.put("Bob", 92);
        studentScores.put("Charlie", 78);
        studentScores.put("Dave", 91);

        List<Map.Entry<String, Integer>> sortedEntries = studentScores.entrySet().stream()
                //.filter(s -> !s.getKey().equals("Bob"))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        System.out.println(sortedEntries);
    }

    @Test
    void filter1() {
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");


        List<Map.Entry<String, Long>> collect = items
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() != 2)
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}