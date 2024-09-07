package com.dydko.geekpedia;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimitiveStreams {

    @Test
    void stream1201() {
        IntStream intStream = IntStream.rangeClosed(1, 10);
        Integer sum = intStream.sum();
        //intStream.forEach(System.out::println);
        System.out.println(intStream);
    }

    @Test
    void stream1202() {

    }
}