package com.dydko.streamsguide;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    private static String fileName = "src/test/resources/test.txt";

    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
    private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

    @Test
    public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
        empList
                .stream()
                .forEach(e -> e.salaryIncrement(10.));
        empList
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void whenMapIdToEmployees_thenGetEmployeeStream() {
        Integer[] empIds = {1, 2, 3};

        List<Employee> employees = Stream
                .of(empIds)
                .map(employeeRepository::findById)
                .collect(Collectors.toList());

        System.out.println(employees);
    }

    @Test
    public void whenCollectStreamToList_thenGetList() {
        List<Employee> employees = empList
                .stream()
                .collect(Collectors.toList());

        System.out.println(employees);
    }

    @Test
    public void whenFilterEmployees_thenGetFilteredStream() {
        Integer[] empIds = {1, 2, 3, 4};

        List<Employee> employeeList = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(e -> e != null)
                .filter(e -> e.getSalary() >= 200000)
                .collect(Collectors.toList());

        System.out.println(employeeList);
    }

    @Test
    public void whenStreamToArray_thenGetArray() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        //System.out.println(namesFlatStream);
        List<String> s = namesFlatStream.stream().collect(Collectors.toList());
        System.out.println(s.size());
    }

    @Test
    public void whenIncrementSalaryUsingPeek_thenApplyNewSalary() {
        List<Employee> empList1 = empList.stream()
                .peek(e -> e.salaryIncrement(10.))
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("-----------------");
        System.out.println(empList1);
    }

    @Test
    public void whenStreamCount_thenGetElementCount() {
        Long empCount = empList.stream()
                .filter(e -> e.getSalary() >= 200000)
                .count();
        System.out.println(empCount);

    }

    @Test
    public void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    @Test
    public void whenFindFirst_thenGetFirstEmployeeInStream() {
        Integer[] empIds = {1, 2, 3, 4};

        Employee employee = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(e -> e != null)
                .filter(e -> e.getSalary() > 100000)
                .findFirst()
                .orElse(null);

        System.out.println(employee);
    }

    @Test
    public void whenFindMin_thenGetMinElementFromStream() {
        Employee firstEmp = empList.stream()
                .min((e1, e2) -> e1.getId() - e2.getId())
                .orElseThrow(NoSuchElementException::new);
        System.out.println(firstEmp);
    }

    @Test
    public void whenApplySumOnIntStream_thenGetSum() {
        Double avgSal = empList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(NoSuchElementException::new);

        System.out.println(avgSal);
    }

    @Test
    void whenApplyReduceOnStream_thenGetValue() {
        Double sumSal = empList.stream()
                .map(Employee::getSalary)
                .reduce(0., Double::sum);
        System.out.println(sumSal);
    }

    @Test
    public void whenCollectBySet_thenGetSet() {
        Set<String> empNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        System.out.println(empNames.size());
    }

    @Test
    public void whenApplySummarizing_thenGetBasicStats() {
        DoubleSummaryStatistics stats = empList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(stats.getMax());
    }

    @Test
    public void whenParallelStream_thenPerformOperationsInParallel() {
        empList.parallelStream().forEach(employee -> employee.salaryIncrement(15.));
        System.out.println(empList);
    }

    @Test
    @SneakyThrows
    public void whenStreamToFile_thenGetFile() {
        String[] words = {
                "hello",
                "refer",
                "world",
                "level"
        };

        try (PrintWriter pw = new PrintWriter(
                Files.newBufferedWriter(Paths.get(fileName)))) {
            Stream.of(words).forEach(pw::println);
        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
    }

    @Test
    public void streamsImprovements() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
                .takeWhile(x -> x <= 5)
                .forEach(System.out::println);
    }

    @Test
    public void streamsImprovements1() {
        Integer number = null;
        Stream<Integer> result = Stream.ofNullable(number);
        result.map(x -> x * x).forEach(System.out::println);
    }

    @Test
    public void concat1() {
        Stream<String> firstStream = Stream.of("A", "B", "C");
        Stream<String> secondStream = Stream.of("D", "E", "F");

        Stream<String> concatStream = Stream.concat(firstStream, secondStream);
        concatStream.forEach(System.out::println);
    }
}