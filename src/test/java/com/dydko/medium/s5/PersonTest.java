package com.dydko.medium.s5;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonTest {

    List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("David", 30)
    );

    @Test
    public void collectExample() {
        Map<Integer, List<Person>>
                listMap = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        listMap.forEach((s1, s2) -> {
            if (s2.size() == 2) {
                System.out.println(s1);
            }
        });

        //.forEach((s1,s2)-> System.out.println(s2.size()));
//                .forEach((age, persons) ->
//                        System.out.println("Age " + age + ": " + persons));
        //.forEach((a, p) -> System.out.println(String.format("User name: %s, user age: %s", a, p)));
    }
}