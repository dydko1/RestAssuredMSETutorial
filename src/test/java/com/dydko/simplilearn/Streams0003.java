package com.dydko.simplilearn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams0003 {

    @Test
    void test123() {
        Random myRan = new Random();

        myRan.ints(0, 5 + 1)
                .limit(10)
                .forEach(System.out::println);

        //System.out.println(myRan);
    }
}