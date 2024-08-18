package com.dydko.winterbe.stream1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {

        List<String> list1 = getTestList()
                .stream()
                .sorted((s1, s2) -> s2.compareTo(s1))
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
                //.forEach(System.out::println);
        System.out.println(list1);

    }

    public static List<String> getTestList() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        return stringCollection;
    }
}
