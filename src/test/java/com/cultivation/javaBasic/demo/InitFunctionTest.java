package com.cultivation.javaBasic.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InitFunctionTest {
    @Test
    void name() {
        IntFunction intFunction = (number) -> number;
        assertEquals(12, intFunction.apply(12));
    }
}

interface IntFunction<T> {
    T apply(T number);
}
