package com.dydko.medium.s4;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {

    List<User> userList = Arrays.asList(
            new User("Alfa", 25, Arrays.asList("123", "456"), true, Arrays.asList("Address1", "Address2")),
            new User("Beta", 33, Arrays.asList("789", "101"), false, Arrays.asList("Address3", "Address4")),
            new User("Gama", 30, Arrays.asList("202", "303"), true, Arrays.asList("Address1", "Address5")),
            new User("Delta", 38, Arrays.asList("208", "232"), true, Arrays.asList("Address3", "Address6"))
    );

    @Test
    void test1() {
        List<User> userUpper = userList.stream()
                .peek(s -> s.setAge(s.getAge() + 100))
                .collect(Collectors.toList());
        System.out.println(userUpper);
    }

    @Test
    void test2() {

    }
}