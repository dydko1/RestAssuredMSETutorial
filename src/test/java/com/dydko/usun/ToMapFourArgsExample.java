package com.dydko.usun;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMapFourArgsExample {
    public static void main(String[] args) {
        List<String> words = List.of("pierwszy", "drugi", "trzeci", "czwarty");

        Map<String, Integer> result = words.stream()
                .collect(Collectors.toMap(
                        String::toUpperCase,
                        String::length,
                        (o, n) -> o,
                        LinkedHashMap::new
                ));

        System.out.println(result);
    }
}