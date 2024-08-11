package com.dydko.presentinanarray;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayRemove {

    @Test
    public void checkArray() {
        List<String> list1 = new ArrayList<>(Arrays.asList("AA", "BB", "CC", "fdsjfjhj"));
        List<String> list2 = new ArrayList<>(Arrays.asList("AA", "BB", "CC2"));
        //list1.removeAll(list2);

        checkLength(list1, list2);
    }

    public void checkLength(List<String> list1, List<String> list2) {
        list1.addAll(list2);
        list1.stream().reduce((s1, s2) -> s1 + s2);
        System.out.println(list1);

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
