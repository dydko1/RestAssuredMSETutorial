package com.dydko.mkyong.java8functionmkyong.predicate;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@NoArgsConstructor
public class StringProcessor1 {

    public List<String> filter1(List<String> list, Predicate<String> predicate) {
        return list
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}