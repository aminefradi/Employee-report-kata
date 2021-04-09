package com.kata.employeeReport;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeReportTest {

    private EmployeeReport employeeReport;

    @Before
    public void setUp(){
        employeeReport = new EmployeeReport();
    }

    @Test
    public void should_return_empty_list_for_no_employees() {

        //when
        List<Employee> employeeList = employeeReport.getEmployees(new ArrayList<>(), false);

        //then
        Assert.assertEquals(employeeList.size(), 0);
    }

    @Test
    public void should_allow_to_work_on_sunday_for_employees_older_or_equals_than_18_years() {

        //given
        List<Employee> employees = Arrays.asList( new Employee("Max", 17),
                new Employee("Sepp", 18),
                new Employee("Nina", 15),
                new Employee("Mike", 51));

        //when
        List<Employee> employeeList = employeeReport.getEmployees(employees, false);

        //then
        Assert.assertEquals(employeeList.size(), 2);
    }

    @Test
    public void should_not_allow_to_work_on_sunday_for_employees_younger_than_18_years() {

        //given
        List<Employee> employees = Arrays.asList( new Employee("Max", 17),
                new Employee("Nina", 15));

        //when
        List<Employee> employeeList = employeeReport.getEmployees(employees, false);

        //then
        Assert.assertEquals(employeeList.size(), 0);

    }

    @Test
    public void should_order_employees_by_name_asc() {
        //given
        List<Employee> employees = Arrays.asList(
                new Employee("Sepp", 18),
                new Employee("Nina", 15),
                new Employee("Mike", 51));

        //when
        List<Employee> employeeList = employeeReport.getEmployees(employees, false);

        //then
        Assert.assertEquals(employeeList, Arrays.asList(new Employee("MIKE", 51), new Employee("SEPP", 18)));
    }

    @Test
    public void should_return_capitalized_employee_names() {
        //given
        List<Employee> employees = Arrays.asList(
                new Employee("Sepp", 18));

        //when
        List<Employee> employeeList = employeeReport.getEmployees(employees, false);

        //then
        Assert.assertEquals(employeeList, Arrays.asList(new Employee("SEPP", 18)));
    }

    @Test
    public void should_order_employees_by_name_desc() {
        //given
        List<Employee> employees = Arrays.asList(
                new Employee("Sepp", 18),
                new Employee("Nina", 15),
                new Employee("Mike", 51));

        //when
        List<Employee> employeeList = employeeReport.getEmployees(employees, true);

        //then
        Assert.assertEquals(employeeList, Arrays.asList(new Employee("SEPP", 18), new Employee("MIKE", 51)));
    }


}
