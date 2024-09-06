package com.dydko.streamsguide;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class EmployeeRepository {

    private List<Employee> empList;

    public Employee findById(Integer id) {
        for (Employee emp : empList) {
            if (emp.getId() == id) {
                return emp;
            }
        }

        return null;
    }
}