package com.cultivation.javaBasic.demo;

public class NullTest {
    public String getName(String string) {
        return string + 1;
    }

    public static void main(String[] args) {
        NullTest nullTest = new NullTest();
        String name = nullTest.getName(null);
        System.out.println(name);
    }

}
