package com.dydko.medium.s2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MeringMap1 {

    @Test
    void mergingMap() {
        Map<String, Integer> document1 = new HashMap<>();
        document1.put("apple", 3);
        document1.put("banana", 2);
        document1.put("cherry", 1);

        Map<String, Integer> document2 = new HashMap<>();
        document2.put("banana", 4);
        document2.put("date", 2);
        document2.put("elderberry", 5);

        Map<String, Integer> mergedMap =
                Stream.of(document1, document2)
                        .flatMap(map -> map.entrySet().stream())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,Integer::sum));

        System.out.println(mergedMap);
    }
}