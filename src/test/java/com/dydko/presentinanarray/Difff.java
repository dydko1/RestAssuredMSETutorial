package com.dydko.presentinanarray;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Difff {

    private static final List listOne = Arrays.asList("Jack", "Tom", "Sam", "John", "James", "Jack");
    private static final List listTwo = Arrays.asList("Jack", "Daniel", "Sam", "Alan", "James", "George");

    @Test
    void diff1() {
        List<String> differences = new ArrayList<>(listOne);
        differences.removeAll(listTwo);
        System.out.println(differences);
    }
}
