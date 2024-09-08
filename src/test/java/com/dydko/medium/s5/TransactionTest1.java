package com.dydko.medium.s5;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TransactionTest1 {

    private final List<Transaction> generateDummy;

    TransactionTest1() {
        generateDummy = TransactionRepository.generateDummyTransactions();
    }

    @Test
    public void test1() {
        Optional<Transaction> largestTransaction = generateDummy
                .stream()
                .max(Comparator.comparingDouble(Transaction::getAmount));
        System.out.println("-----------");
        System.out.println(largestTransaction.orElse(null));
        System.out.println("-----------");
    }

    @Test
    public void test2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers
                .stream()
                .reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(sum);
    }

    @Test
    public void test3() {
        List<String> words = Arrays.asList("Hello", " ", "World", "!");

        String concatenated=words
                .stream()
                .reduce("",String::concat);
        System.out.println(concatenated);
    }
}