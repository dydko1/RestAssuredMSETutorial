package com.dydko.cheatsheetonjavacollection.array1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayListDemo1 {
    @Test
    public void arrayDemo1() {
        List<Integer> list = new ArrayList<>();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] arr1 = {2, 34, 5};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(arr1));

//        List<List<String>> countries = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            countries.add(new ArrayList<>(Arrays.asList("ab" + i, "cd" + i * i)));
//        }

        List<String> countries2 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        countries2.add("4");
        countries2.add(2, "dddddddddddddddddddddddddddd");
        countries2.sort(Comparator.naturalOrder());
        System.out.println(countries2);
    }
}
