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
        //Example 1: Summing the Elements
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    }
}