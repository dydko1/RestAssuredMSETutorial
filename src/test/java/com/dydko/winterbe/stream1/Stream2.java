package com.dydko.winterbe.stream1;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.dydko.winterbe.stream1.Stream1.getTestList;

public class Stream2 {
    public static void main(String[] args) {
        Optional<String> reduced =
                getTestList()
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
    }
}