package com.cultivation.javaBasic.demo;

import com.cultivation.javaBasic.util.StringFunc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LambdaTest {
    @Test
    void should_get_number() {
        CharSupplier returnNumber = (string) -> string;
        assertEquals('h', returnNumber.getAsChar('h'));
    }
}

@FunctionalInterface
interface CharSupplier {
    char getAsChar(char string);
}

interface BooleanFun{}
