package com.dydko.medium.s4;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIterate {

    @Test
    void testIter001() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
