package com.cultivation.javaBasic.demo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Reflect {
    String name;

    public Reflect() {

    }

    public String test() {
        return "hhh";
    }
}

class Demo {
    @Test
    void name() throws IllegalAccessException, InstantiationException {
        Reflect reflect = Reflect.class.newInstance();
        Arrays.stream(Reflect.class.getDeclaredMethods()).map(method -> {
            try {
                method.invoke(reflect);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return method.getName();
        }).toArray(String[]::new);
    }
}
