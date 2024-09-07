package com.dydko.medium.s4;

import org.junit.jupiter.api.Test;
import java.util.stream.Stream;

public class Stream0001 {
    @Test
    void stream001() {
        Stream<Integer> powerOfTwo = Stream.iterate(1, n -> n * 2);
        powerOfTwo
                .limit(5 + 1)
                .forEach(System.out::println);
    }

}