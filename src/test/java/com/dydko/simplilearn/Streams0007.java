package com.dydko.simplilearn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams0007 {

    @Test
    void test123() {

        List<Integer> nums = Arrays.asList(4, 1, 2, 9, 2, 4, 13, 0, -14, 22, -14, 0, 4);
        List<Integer> distinctNumbers=nums
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);

    }
}