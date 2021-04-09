package com.kata.employeeReport;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Employee service
 */
public class EmployeeReport {

    /**
     * Compute list employees
     * @param employees
     * @param desc
     * @return
     */
    public List<Employee> getEmployees(List<Employee> employees, boolean desc){

        return employees.stream()
                        .filter(employee -> isOverEighteen(employee)) //
                        .sorted(desc ? Comparator.comparing(Employee::getName).reversed() : Comparator.comparing(Employee::getName)) //
                        .map(employee -> new Employee(employee.getName().toUpperCase(), employee.getAge())) //
                        .collect(Collectors.toList());
    }

    /**
     * Returns whether an employee is under 18
     * @param employee
     * @return
     */
    private boolean isOverEighteen(Employee employee){
        return employee.getAge() >= 18;
    }

}
