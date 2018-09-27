package com.cultivation.javaBasic.demo;

public class ClassTest {
    public void createTest() {
        new test();
    }

    public static class test {

    }

    public static void main(String[] args) {
        ClassTest classTest = new ClassTest();
        new test();
        classTest.createTest();
    }
}
