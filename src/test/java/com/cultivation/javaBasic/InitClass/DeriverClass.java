package com.cultivation.javaBasic.InitClass;

import org.junit.jupiter.api.Test;

public class DeriverClass extends SuperClass {

    public DeriverClass() {
        System.out.println("DeriverClass no parameter constructor");
    }


    public DeriverClass(String string) {
        System.out.println("DeriverClass with parameter constructor");
    }

    {
        System.out.println("DeriverClass init block");
    }

    static {
        System.out.println("DeriverClass static init block");
    }

    int a = getA();

    private int getA() {
        System.out.println("DeriverClass with field");
        return 0;
    }

    @Override
    public void getName() {
        super.getName();
    }

    static int b = getB();

    private static int getB() {
        System.out.println("DeriverClass with static field");
        return 0;
    }
}

class demo {
    @Test
    void name() {
        new DeriverClass();
    }
}
