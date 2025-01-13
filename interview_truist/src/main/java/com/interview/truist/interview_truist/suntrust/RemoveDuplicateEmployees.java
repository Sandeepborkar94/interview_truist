package com.interview.truist.interview_truist.suntrust;

import java.util.*;
import java.util.stream.Collectors;

class Employee
{
    private int empID;
    private String name;

    // Constructor
    public Employee(int empID, String name) {
        this.empID = empID;
        this.name = name;
    }

    // Getters and Setters
    public int getEmpID() {
        return empID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                '}';
    }
}

public class RemoveDuplicateEmployees {
    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice"),
                new Employee(102, "Bob"),
                new Employee(101, "Alice"),
                new Employee(103, "Charlie"),
                new Employee(102, "Bob")
        );

        // Remove duplicates based on empID
        List<Employee> distinctEmployees = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getEmpID, // Use empID as the key
                        e -> e,            // Use the employee object as the value
                        (existing, replacement) -> existing // Keep the existing employee in case of duplicate
                ))
                .values()
                .stream()
                .collect(Collectors.toList());

        // Print the distinct employees
        distinctEmployees.forEach(System.out::println);
    }
}
