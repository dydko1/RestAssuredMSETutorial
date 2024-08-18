package com.dydko.winterbe.stream2;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

public class ListDuplicates {
    @Test
    void displayAll() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);  // a1
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);  // a1
//        myList = myList
//                .stream()
//                .filter(s1 -> s1.startsWith("c"))
//                .map(String::toUpperCase)
//                .sorted()
//                .collect(Collectors.toList());
//        System.out.println(myList);
    }
}