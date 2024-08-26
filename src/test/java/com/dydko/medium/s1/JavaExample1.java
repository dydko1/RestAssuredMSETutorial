package com.dydko.medium.s1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaExample1 {
    public static void main(String[] args) {

        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Long> result = items
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()));

        System.out.println(result);
    }
}
