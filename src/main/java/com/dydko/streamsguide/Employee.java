package com.dydko.streamsguide;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {

    private Integer id;
    private String name;
    private Double salary;

    public void salaryIncrement(Double percentage) {
        setSalary(salary + percentage * salary / 100);
    }
}