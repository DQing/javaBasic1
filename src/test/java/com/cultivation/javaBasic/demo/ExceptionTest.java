package com.cultivation.javaBasic.demo;

public class ExceptionTest {

    void a() {
        throw new IllegalArgumentException();
    }

    void b() {
        a();
    }

    void c() {
        b();
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.c();
    }
}

