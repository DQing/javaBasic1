package com.cultivation.javaBasic.demo;

import com.cultivation.javaBasic.util.Employee;

public class AnonymousTest {
    public static void main(String[] args) {
        Employee employee = new Employee() {
            @Override
            public String getTitle() {
                return "employee title";
            }
        };
        employee.getTitle();
    }
}
