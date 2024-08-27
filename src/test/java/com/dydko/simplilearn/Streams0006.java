package com.dydko.simplilearn;

import com.dydko.winterbe.pred1.Oprt1;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Streams0006 {

    @Test
    void test123() {
        List<Integer> nums = Arrays.asList(4, 1, 2, 9, 10, 23, 65, 6, 98, -14, 33);

        Optional<Integer> minNumbers=nums
                .stream()
                .min((n1,n2)->n1.compareTo(n2));
        System.out.println(minNumbers);

    }
}