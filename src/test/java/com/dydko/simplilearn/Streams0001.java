package com.dydko.simplilearn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Streams0001 {

    @Test
    void emptyString() {
        List<String> names = Arrays.asList("Mike", "David", "", "John", "Jane", "Charlie", "Alan", "", "Joanna", "");

        Long count = names
                .stream()
                .filter(n -> n.isEmpty())
                .count();
        System.out.println(count);

    }
}