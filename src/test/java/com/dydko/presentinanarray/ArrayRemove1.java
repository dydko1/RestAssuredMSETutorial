package com.dydko.presentinanarray;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayRemove1 {

    @Test
    public void checkArray() {
        List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
        List<String> otherList = Arrays.asList("red", "green", "green", "yellow");

        checkLength(list, otherList);
    }

    public void checkLength(List<String> list, List<String> otherList) {
        Set<String> result = list.stream()
                .distinct()
                .filter(otherList::contains)
                .collect(Collectors.toSet());

        //Set<String> commonElements = new HashSet(Arrays.asList("red", "green"));

        System.out.println(result);

//        List<String> list = new ArrayList<>(list1);
//        list.removeIf(p -> list2.contains(p));
//        System.out.println(list);
//        System.out.println(list1);
//        System.out.println("==================================");
//        list = new ArrayList<>(list2);
//        list.removeIf(p -> list1.contains(p));
//        System.out.println(list);
//        System.out.println(list2);
    }
}
