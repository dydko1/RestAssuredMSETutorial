package com.dydko.usun;

import java.util.*;
import java.util.stream.Collectors;

public class MergeExample {
    public static void main(String[] args) {
        List<String> names = List.of("Mirek", "Asia", "Mirek", "Leszek", "Mieszek");

        Map<String, Integer> map = names.stream()
                .collect(Collectors.toMap(
                        n -> n,
                        String::length,
                        (o, n) -> n,
                        LinkedHashMap::new
                ));

        System.out.println(map);
    }
}
