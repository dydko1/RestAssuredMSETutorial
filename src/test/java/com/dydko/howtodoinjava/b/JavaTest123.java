package com.dydko.howtodoinjava.b;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaTest123 {

    @Test
    public void test1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> evenNumber = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumber);
    }

    @Test
    public void test2() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5, 6);
        integerStream.forEach(System.out::println);
    }

    @Test
    public void streamOfArray() {
        Stream<Integer> stream = Stream.of(new Integer[]{1, 2, 3, 5, 6, 7, 8});
        stream.forEach(System.out::println);
    }

    @Test
    public void streamList() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Stream<Integer> integerStream = list.stream();
        integerStream.forEach(System.out::println);
    }

    @Test
    public void randomNumbers() {
        Stream<Integer> randomNumbers = Stream
                .generate(() -> (new Random()).nextInt(100));
        randomNumbers.limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void stringToken() {
        IntStream intStream = "1234555".chars();
        intStream
                .forEach(System.out::println);
        System.out.println("--------------------");
        Stream<String> stream = Stream.of("A$B$C".split("\\$"));
        stream.forEach(System.out::println);
    }

    @Test
    public void streamCollection() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Stream<Integer> stream = list.stream();
        List<Integer> evenNumber = stream
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumber);
    }

    @Test
    public void elementToArray1() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        Stream<Integer> stream = list
                .stream();
        Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        System.out.println(evenNumbersArr[0]);
    }
}