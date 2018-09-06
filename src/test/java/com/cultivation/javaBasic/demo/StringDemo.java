package com.cultivation.javaBasic.demo;

public class StringDemo {
    public static void main(String[] args) {
//        getEquals();
        System.out.println("hello".substring(0, 5));
    }

    private static void getEquals() {
        Object object = new Object();
        Object object1 = object;
        boolean equals = object.equals(object1);
        System.out.println(equals);
        System.out.println("hello".equals("hello"));
        System.out.println("hello" == "hello");
    }
}
