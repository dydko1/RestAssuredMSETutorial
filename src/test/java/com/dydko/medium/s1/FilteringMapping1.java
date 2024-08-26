package com.dydko.medium.s1;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilteringMapping1 {

    @Test
    void mapping1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().filter(n -> n % 2 == 0)
                .map(n -> n * n).collect(Collectors.toList());

        System.out.println(squares);
    }

    @Test
    void summing() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sum = numbers
                .stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    void grouping() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Grocery", 50.0),
                new Transaction("Grocery", 30.0),
                new Transaction("Shopping", 100.0),
                new Transaction("Shopping", 150.0),
                new Transaction("Grocery", 20.0)
        );

        Map<String, List<Transaction>> collect = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getType));

        System.out.println(collect);
    }
}