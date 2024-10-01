package com.dydko.generic;

import java.util.*;

public class SubstitutionExample {

    public static void main(String[] args) {
        List<String> someList = new ArrayList<>();
        someList
                .add("aaa");
        Set<String> someSet = new HashSet<>();
        someSet
                .add("bbb");
        Queue<String> someQueue = new PriorityQueue<>();
        someQueue
                .add("ccc");

        SubstitutionExample example = new SubstitutionExample();
        example.doSomethingWithElements(someList);
        example.doSomethingWithElements(someSet);
        example.doSomethingWithElements(someQueue);
    }

    public void doSomethingWithElements(Collection<String> someCollection) {
        for (String element : someCollection) {
            System.out.println("element1: " + element);
        }
    }

}