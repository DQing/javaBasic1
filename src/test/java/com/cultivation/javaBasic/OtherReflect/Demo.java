package com.cultivation.javaBasic.OtherReflect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Demo {
    @Test
    void should_test_array_not_equals() {
        Student[] students = new Student[1];
        Person[] people = students;
        assertNotEquals(students.getClass().getSuperclass(), people.getClass());
        assertEquals(students.getClass().getComponentType(), people.getClass().getComponentType());
    }
}
