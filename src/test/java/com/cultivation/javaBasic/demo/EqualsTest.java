package com.cultivation.javaBasic.demo;

import java.util.HashSet;
import java.util.Objects;

public class EqualsTest {
    public static void main(String[] args) {
        Employee employee = new Employee("rajeev", 24);
        Employee employee1 = new Employee("rajeev", 25);
        Employee employee2 = new Employee("rajeev", 24);

        HashSet<Employee> employeeHashSet = new HashSet<Employee>();
        employeeHashSet.add(employee);
        System.out.println(employeeHashSet.contains(employee2));
        System.out.println("employee.hashCode():  " + employee.hashCode()
                + "  employee2.hashCode():" + employee2.hashCode());
    }
}

class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Employee))
            return false;
        Employee employee = (Employee) obj;
        return employee.getAge() == this.getAge()
                && employee.getName() == this.getName();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
//        int hash = Objects.hash(name, age);
        return result;
    }
}
