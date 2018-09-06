package com.cultivation.javaBasic.InitClass;

public class SuperClass {
    public SuperClass() {
        System.out.println("SuperClass no parameter constructor");
    }

    public SuperClass(String string) {
        System.out.println("SuperClass with parameter constructor");
    }

    {
        System.out.println("SuperClass init block");
    }
    static int b = getB();

    static {
        System.out.println("SuperClass static init block");
    }

    int a = getA();

    private int getA() {
        System.out.println("SuperClass with field");
        return 0;
    }


    private static int getB() {
        System.out.println("SuperClass with static field");
        return 0;
    }
}
