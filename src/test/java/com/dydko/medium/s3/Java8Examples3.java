package com.dydko.medium.s3;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Examples3 {

    @Test
    void printSum() {
        List<Item1> item1s = Arrays.asList(
                new Item1("apple", 10, new BigDecimal("9.99")),
                new Item1("banana", 20, new BigDecimal("19.99")),
                new Item1("orang", 10, new BigDecimal("29.99")),
                new Item1("watermelon", 10, new BigDecimal("29.99")),
                new Item1("papaya", 20, new BigDecimal("9.99")),
                new Item1("apple", 10, new BigDecimal("9.99")),
                new Item1("banana", 10, new BigDecimal("19.99")),
                new Item1("apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Long> counting = item1s.stream().collect(
                Collectors.groupingBy(s -> s.getName(), Collectors.counting()));

        System.out.println(counting);
    }
}