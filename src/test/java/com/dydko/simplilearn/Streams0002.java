package com.dydko.simplilearn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams0002 {

    @Test
    void listSquare() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> listSquareNumbers = numbers
                .stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(listSquareNumbers);
    }
}