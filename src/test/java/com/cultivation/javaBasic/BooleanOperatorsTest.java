package com.cultivation.javaBasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BooleanOperatorsTest {

    @SuppressWarnings({"PointlessBooleanExpression", "ConstantConditions"})
    @Test
    void should_perform_logical_boolean_operations() {
        boolean[] actualResults = {
                true && true,
                true && false,
                false && false,  //逻辑与
                true || true,
                true || false,
                false || false,
                true & true,  //按位与
                true & false, //&操作运算符，两个操作数都为1，结果才是1,否则为0
                false & false,
                true | true,
                true | false,
                false | false,
                3 == 7,
                4 != 5
        };

        // TODO: please modify the following code to pass the test
        // <--start
        boolean[] expectedResult = {
                true,
                false,
                false,

                true,
                true,
                false,

                true,
                false,
                false,

                true,
                true,
                false,

                false,
                true
        };
        // --end-->

        assertArrayEquals(expectedResult, actualResults);
        assertTrue(true & true);
    }

    @Test
    void should_do_bitwise_and_boolean_operation() {
        final int value = 0x1234_abcd;
        final int mask = 0x000f_ff00;
        /* 1&a == a
         * a&0 == 0
         * */
        final int expected = 0x0004_ab00;

        assertEquals(expected, value & mask);
    }

    @Test
    void should_test() {
        int value1 = 0x0111;
        int value2 = 0x2000; //0x2000 0x0100
        int value3 = 0x0100; // =0x000
        int result = value1 & value2 | value3;

        int value = 0x0000_ffff; //0xffff0000 0x0111
        int result1 = value1 & ~value; // 0x 01110000
        int excepted = 0x11110000;

        int excepted1 = 0x0100;
        assertEquals(excepted, result1);
        assertEquals(excepted1, result);
    }

    @Test
    void should_do_bitwise_or_boolean_operation() {
        final int value = 0x1234_0000;
        final int mask = 0x0000_abcd;

        // TODO: please write down the result directly to pass the test.
        // <--start
        final int expected = 0x1234_abcd;
        // --end-->

        assertEquals(expected, value | mask);
    }

    @Test
    void should_do_bitwise_not_operation() {
        final int value = 0x0000_ffff;

        // TODO: please write down the result directly to pass the test.
        // <--start
        /*
         * */
        final int expected = 0xffff_0000;
        // --end-->

        assertEquals(expected, ~value);
    }
}
