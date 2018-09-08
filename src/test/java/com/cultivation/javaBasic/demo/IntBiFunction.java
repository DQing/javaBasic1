package com.cultivation.javaBasic.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntBiFunction {
    @Test
    void name() {
        BiFunction biFunction = (a, b) -> a + b;
        assertEquals(3, biFunction.apply(1, 2));
    }
}

interface BiFunction {
    int apply(int a, int b);
}
