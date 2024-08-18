package com.dydko.winterbe.tut1;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LambdaExpression1 {
    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    @Test
    public void sortingArr1() {
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });

        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println(names);
    }
}
