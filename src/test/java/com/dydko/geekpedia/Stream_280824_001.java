package com.dydko.geekpedia;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream_280824_001 {

    @Test
    void stream123() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(s -> s.toUpperCase(Locale.ROOT))
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void stream1234() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");

        List<String> filtered = names.stream()
                .filter(n -> n.startsWith("A") || n.startsWith("B"))

                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    @Test
    void stream1235() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");

        Integer totalLength = names.stream()
                .mapToInt(s -> s.length())
                .reduce(0, Integer::sum);
        System.out.println(totalLength);
    }

    @Test
    void stream1236() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Miro", "Miro");

        Set<String> nameSet = new HashSet<>(names);
        System.out.println(nameSet);
    }

   @Test
    void stream12311() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Miro");

        Map<String, Integer> nameMap = names.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(nameMap);
    }


}