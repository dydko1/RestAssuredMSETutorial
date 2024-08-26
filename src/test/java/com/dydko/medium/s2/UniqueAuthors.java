package com.dydko.medium.s2;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueAuthors {

    @Test
    void uniqueAuthors() {
        List<Book1> book1s = Arrays.asList(
                new Book1("Book 1", Arrays.asList("Author 1", "Author 2")),
                new Book1("Book 2", Arrays.asList("Author 2", "Author 3", "Mirooroorroor")),
                new Book1("Book 3", Arrays.asList("Author 1", "Author 3")));

        Map<String, Long> collect = book1s
                .stream()
                .flatMap(b1 -> b1
                        .getAuthor()
                        .stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }

    @Test
    void evenOdd() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> oddAndEvenNumbers = numbers
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(oddAndEvenNumbers);
    }

    @Test
    void filtering() {
        Map<String, Integer> employeeSalaries = new HashMap<>();
        employeeSalaries.put("Alice", 5000);
        employeeSalaries.put("Bob", 7000);
        employeeSalaries.put("Charlie", 4000);
        employeeSalaries.put("Dave", 6000);

        int salaryThreshold = 5000;

        List<String> highPaidEmployees = employeeSalaries.entrySet().stream()
                .filter(entry -> entry.getValue() > salaryThreshold)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(highPaidEmployees);
    }
}