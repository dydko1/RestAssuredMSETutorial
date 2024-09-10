package com.dydko.date1;

import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.DoubleStream.concat;

public class Date123Test {

    @Test
    public void dateTest1() {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.now().minusYears(2);

        //Stream<LocalDate> next3Days = today.datesUntil(today.plusDays(3));
        Long days = Math.abs((ChronoUnit.DAYS.between(today, date)));
        System.out.println(LocalDate.now().minusDays(days));
    }

    @Test
    public void dateTest2() {
        LocalDate today = LocalDate.now();
        Stream<LocalDate> nextThreeDays = Stream.iterate(today, d -> d.plusDays(-100));
        List<LocalDate> list = nextThreeDays
                .limit(30)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void dateTest3() {
        //Test123 test123 = Test123.HIGH;
        System.out.println(Test123.HIGH.getVal());
    }

    @Test
    public void dateTest4() {
        // ArrayList with duplicate elements
        ArrayList<Integer> numbersList
                = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

        Map<Integer, Long> elementCountMap = numbersList.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

        System.out.println(elementCountMap);
        System.out.println("--------------------------");
        Set<Map.Entry<Integer, Long>> ss = elementCountMap.entrySet()
                .stream()
                .filter(s -> s.getValue() != 2)
                .collect(Collectors.toSet());

        System.out.println(ss);
    }

    @Test
    public void dateTest5() {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("d1", "dd1");
        map1.put("d2", "dd2");
        map1.put("d3", "dd4");
    }

    @Test
    public void dateTest6() {
        Iterator<String> iterator = Arrays.asList("a", "b", "c").listIterator();
        Spliterator<String> splitItr = Spliterators
                .spliteratorUnknownSize(iterator, Spliterator.ORDERED);
        Stream<String> stream = StreamSupport.stream(splitItr, false);
        System.out.println(stream.collect(Collectors.toList()));
    }

    @Test
    public void dateTest7() {
        Stream<Integer> first = Stream.of(1, 2);
        Stream<Integer> second = Stream.of(3, 4);
        Stream<Integer> third = Stream.of(5, 6);
        Stream<Integer> fourth = Stream.of(7, 8);

        Stream<Integer> resultingStream = Stream.concat(first, Stream.concat(second, Stream.concat(third, fourth)));
        System.out.println(resultingStream.filter(f -> f != 1).collect(Collectors.toList()));
    }
}