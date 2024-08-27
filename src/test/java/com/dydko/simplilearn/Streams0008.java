package com.dydko.simplilearn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams0008 {

    @Test
    void test123() {

        List<Integer> nums = Arrays.asList(-4, -8, 0, -2, -10);

        Boolean allNeg = nums
                .stream()
                .allMatch(n -> n <= 0);
        System.out.println(allNeg);

        boolean mulofthree = nums.stream().noneMatch(num -> num%3==0);
        System.out.println(mulofthree);
    }
}