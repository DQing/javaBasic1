package com.cultivation.javaBasic;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.jupiter.api.Assertions.*;

class FloatingTypeTest {
    @Test
    void should_not_get_rounded_result_if_convert_floating_number_to_integer() {
        final float floatingPointNumber = 2.75f;
        final int integer = (int) floatingPointNumber;

        // TODO: Please change the result to pass the test.
        // <!--start
        final int expected = 2;
        // --end-->

        assertEquals(expected, integer);
    }

    @Test
    void should_round_the_number() {
        byte byteNumber = 10;
        short shortNumber = 10;
        int intNumber = 10;
        long longNumber = 10;
        float floatNumber = 10;
        double doubleNumber = 10;

        byte s1 = (byte) shortNumber;
        short s2 = byteNumber;
        long f1 = (long) floatNumber;

    }

    @SuppressWarnings({"divzero", "NumericOverflow"})
    @Test
    void should_judge_special_double_cases() {
        assertTrue(isInfinity(1d / 0d));
        assertTrue(isInfinity(-1d / 0d));
        assertFalse(isInfinity(2d));
        assertFalse(isInfinity(Double.NaN));

        assertTrue(isNan(0d / 0d));
        assertFalse(isNan(Double.NEGATIVE_INFINITY));
        assertFalse(isNan(Double.POSITIVE_INFINITY));
    }

    @Test
    void should_not_round_number_when_convert_to_integer() {
        final float floatingPointNumber = 2.75f;
        final int integer = (int) floatingPointNumber;

        // TODO: Please change the result to pass the test.
        // <!--start
        final int expected = 2;
        // --end-->

        assertEquals(expected, integer);
    }

    @SuppressWarnings("unused")
    @Test
    void should_round_number() {
        final double floatingPointNumber1 = 2.75;
        final double floatingPointNumber2 = 2.15;

        // TODO: Please call some method to round the floating point number.
        // <!--start
        final long rounded1 = Math.round(floatingPointNumber1);
        final double rounded2 = Math.floor(floatingPointNumber1);
        final double rounded3 = Math.ceil(floatingPointNumber1);

        final long rounded4 = Math.round(floatingPointNumber2);
        final double rounded5 = Math.floor(floatingPointNumber2);
        final double rounded6 = Math.ceil(floatingPointNumber2);
        // --end-->

        assertEquals(3L, rounded1);
        assertEquals(2.0, rounded2);
        assertEquals(3.0, rounded3);

        assertEquals(2L, rounded4);
        assertEquals(2.0, rounded5);
        assertEquals(3.0, rounded6);

    }

    @SuppressWarnings("unused")
    private boolean isNan(double realNumber) {
        // TODO: please implement the method to pass the test.
        return Double.isNaN(realNumber);
    }

    @SuppressWarnings("unused")
    private boolean isInfinity(double realNumber) {
        // TODO: please implement the method to pass the test.
        return Double.isInfinite(realNumber);
    }

    @Test
    void should_test_infinite() {
        assertEquals(2.0 / 0, 3.0 / 0);
        assertEquals(0.0 / 0.0, 0.0 / 0);
        assertTrue(2.0 / 0 == 2.0 / 0);
        assertFalse(0.0 / 0 == 0.0 / 0);
        assertSame(0 / 1, 0 / 1);
    }

    /*
     * The coach should ask the following questions for the correspond test method:
     *
     * - Can we compare NaN using == directly?
     * - Can we compare XXX_INFINITY using == directly?
     */
}
