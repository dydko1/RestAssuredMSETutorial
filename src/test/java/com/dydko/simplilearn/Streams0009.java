package com.dydko.simplilearn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Stream;

public class Streams0009 {

    List<String> nums = Arrays.asList("4", "1", "2", "9", "10", "23", "65", "6", "98", "-14", "33");
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    @Test
    void test123() {
        OptionalInt maxNumber = nums
                .stream()
                .mapToInt(n -> Integer.valueOf(n))
                .max();
        System.out.println(maxNumber);
    }

    @Test
    void test1234() {
        OptionalDouble average = nums
                .stream()
                .mapToLong(s -> Long.valueOf(s))
                .average();
        System.out.println(average.getAsDouble());
    }

    @Test
    void test1235() {
        int evenNumber = numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, (sum, x) -> sum + x);
        System.out.println(evenNumber);
    }

    @Test
    void test1236() {
        Stream.generate(Math::random).limit(10);
    }
}