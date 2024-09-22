package com.dydko.mkyong.java8functionmkyong.predicate;


import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Predicate2 {
    final List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    final List<String> list2 = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

    @Test
    public void function1() {
        Predicate<Integer> noGreaterThen5 = x -> x > 5;
        List<Integer> list2 = list
                .stream()
                .filter(noGreaterThen5)
                .collect(Collectors.toList());
        System.out.println(list2);
    }

    @Test
    public void predicateAnd() {
        Predicate<Integer> between = x -> (x > 5 && x < 10);
        List<Integer> list2 = list
                .stream()
                .filter(between)
                .collect(Collectors.toList());
        System.out.println(list2);
    }

    @Test
    public void noGreaterNoLess() {
        Predicate<Integer> cond1 = x -> x > 5;
        Predicate<Integer> cond2 = x -> x < 4;

        List<Integer> list2 = list
                .stream()
                .filter(cond1.and(cond2))
                .collect(Collectors.toList());
        System.out.println(list2);
    }

    @Test
    public void filter1() {
        StringProcessor1 stringProcessor = new StringProcessor1();
        System.out.println(
                stringProcessor
                        .filter1(list2, x -> x.contains("A"))
        );

        System.out.println(
                stringProcessor
                        .filter1(list2, x -> x.length() > 2)
        );
    }

    @Test
    public void filter2() {
        Predicate<String> startWithA = x -> x.startsWith("A");
        boolean bol1=startWithA
                .or(x->x.length()>50)
                .test("miro tu był");
    }
}