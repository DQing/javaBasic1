package com.cultivation.javaBasic.demo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertSame;

public class assertTest {
    @Test
    void should_get_a_test() {
//        assertEquals(1, 2, () -> "hello");
//        assertLinesMatch(Arrays.asList("4", "5", "7"), Arrays.asList("4", "5", "6"));
        LocalDate localDate1 = LocalDate.of(2018, 5, 10);
        LocalDate localDate2 = LocalDate.of(2018, 5, 10);
        assertEquals(localDate1,localDate2);
    }
}
