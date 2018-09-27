package com.cultivation.javaBasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTypeTest {

    @Test
    void should_get_range_of_primitive_int_type() {
        final int maximum = 0x7fffffff;
        // 0111
        final int minimum = 0x80000000;
        // 1000
        // TODO: You should not write concrete number here. Please find a property or constant instead.
        // <!--start
        final int maximumSymbol = Integer.MAX_VALUE;
        final int minimumSymbol = Integer.MIN_VALUE;
        // --end-->

        assertEquals(maximumSymbol, maximum);
        assertEquals(minimumSymbol, minimum);
    }

    @Test
    void should_return_nagetive() {
        final int maximum = 10;
        final int minimum = Integer.MIN_VALUE;
        //  -2147483648
        int max = Integer.highestOneBit(maximum);
        int min = Integer.highestOneBit(minimum);
        assertTrue(max > 0);
        assertTrue(min < 0);
    }

    @Test
    void should_test_first() {
        for (int i = Integer.MIN_VALUE; i < 0; i++) {
            assertEquals(1, i >>> 31);
        }
    }

    @Test
    void should_test_move() {
        int number1 = 1;
        int i = number1 >> 1;
        // 0001
        // 0000
        int i1 = number1 << 1;
        // 0001
        // 0010
        int number2 = 0x7fff_ffff;
        int i2 = number2 << 1;
        //  0xffff_fffE
        // 0x8000_0000
        assertEquals(0, i);
        assertEquals(2, i1);
//        System.out.println(i2);
        System.out.println(0x8000_0000);
        System.out.println(0x8000_0000 + 1);
        assertEquals(0xffff_fffE, i2);
    }

    @Test
    void should_test_no_sign_move() {
        int number3 = 0x7fff_ffff;
        //0x3fff_ffff
        int i3 = number3 >>> 1;
        assertEquals(0x3fff_ffff, i3);

        int number = 0x8000_0000;
        int i = number >>> 1;
        assertEquals(0x4000_0000, i);
    }

    @Test
    void should_get_range_of_primitive_short_type() {
        final short maximum = 32767;
        final short minimum = -32768;

        // TODO: You should not write concrete number here. Please find a property or constant instead.
        // <!--start
        final short maximumSymbol = Short.MAX_VALUE;
        final short minimumSymbol = Short.MIN_VALUE;
        // --end-->

        assertEquals(maximumSymbol, maximum);

        assertEquals(minimumSymbol, minimum);
    }

    @Test
    void should_get_range_of_primitive_long_type() {
        final long maximum = 0x7fff_ffff_ffff_ffffL;
        final long minimum = -0x8000000000000000L;

        // TODO: You should not write concrete number here. Please find a property or constant instead.
        // <!--start
        final long maximumSymbol = Long.MAX_VALUE;
        final long minimumSymbol = Long.MIN_VALUE;
        // --end-->

        assertEquals(maximumSymbol, maximum);
        assertEquals(minimumSymbol, minimum);
    }

    @Test
    void should_get_range_of_primitive_byte_type() {
        final byte maximum = 127;
        final byte minimum = -128;

        // TODO: You should not write concrete number here. Please find a property or constant instead.
        // <!--start
        final byte maximumSymbol = Byte.MAX_VALUE;
        final byte minimumSymbol = Byte.MIN_VALUE;
        // --end-->
        System.out.println((short) 0x8000 + 1);
        assertEquals(maximumSymbol, maximum);
        assertEquals(minimumSymbol, minimum);
    }

    @Test
    void should_overflow_silently() {
        int theNumberWillOverflow = Integer.MAX_VALUE;
        ++theNumberWillOverflow;

        // TODO: Please correct the value to pass the test.
        // <--start
        final int expectedResult = Integer.MIN_VALUE;
        // --end-->

        assertEquals(expectedResult, theNumberWillOverflow);
    }

    @Test
    void should_underflow_silently() {
        int theNumberWillUnderflow = Integer.MIN_VALUE;
        --theNumberWillUnderflow;

        // TODO: Please correct the value to pass the test.
        // <--start
        final int expectedResult = Integer.MAX_VALUE;
        // --end-->

        assertEquals(expectedResult, theNumberWillUnderflow);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void should_throw_exception_when_overflow() {
        int theNumberWillOverflow = Integer.MAX_VALUE;

        assertThrows(ArithmeticException.class, () -> add(theNumberWillOverflow, 1));
    }

    @Test
    void just_prevent_lazy_implementation() {
        assertEquals(3, add(1, 2));
    }

    @SuppressWarnings("PointlessArithmeticExpression")
    @Test
    void should_take_care_of_number_type_when_doing_calculation() {
        final double result1 = 2 / 3 * 5;
        final double result2 = 2 * 5 / 3;

        // TODO: please modify the following lines to pass the test
        // <!--start
        final double expectedResult1 = 0;
        final double expectedResult2 = 3;
        // --end-->

        assertEquals(expectedResult1, result1, +1.0E-05);
        assertEquals(expectedResult2, result2, +1.0E-05);
    }

    @Test
    void should_truncate_number_when_casting() {
        final int integer = 0x0123_4567;
        final short smallerInteger = (short) integer;

        // TODO: please modify the following lines to pass the test
        // <!--start
        final short expected = 0x4567;
        // --end-->

        assertEquals(expected, smallerInteger);
    }

    @Test
    void should_int_to_short() {
        final int integer = 0x0123_8567;
        final short smallerInteger = (short) integer;
        int oneBit = Integer.highestOneBit(integer);
        int anotherBit = Integer.highestOneBit(smallerInteger);
        assertTrue(oneBit > 0);
        assertTrue(anotherBit < 0);
    }

    @Test
    void should_increment() {
        int integer = 3;

        int result = integer++;

        // TODO: please modify the following code to pass the test
        // <--start
        final int expectedCurrentInteger = 4;
        final int expectedResult = 3;
        // --end-->

        assertEquals(expectedCurrentInteger, integer);
        assertEquals(expectedResult, result);
    }

    @Test
    void should_increment_2() {
        int integer = 3;

        int result = ++integer;

        // TODO: please modify the following code to pass the test
        // <--start
        final int expectedCurrentInteger = 4;
        final int expectedResult = 4;
        // --end-->

        assertEquals(expectedCurrentInteger, integer);
        assertEquals(expectedResult, result);

    }

    private int add(int left, int right) {
        // TODO: Please implement the method. Adding two numbers.
        return Math.addExact(left, right);
    }

    /*
     * The coach should ask the following questions to make the candidates be focused on the number representations:
     *
     * - How many bytes needed to store a(n) int/long/short/byte.
     * - How many bits are there in a(n) int/long/short/byte.
     * - Why integer number over/underflow is dangerous?
     * - What is `final` variable?
     * - Can Java use uninitialized variable?
     * - Among all the integer types. Which one can be implicitly convert to another.
     * - What is the resulting type for the operation (+ - * / %) of two `short` variable?
     * - When two values are combined with a binary operator both operands are converted to a common type before
     *   the operation is carried out. Do you know the conversion rules?
     *   * If either of the operands is of type double, the other one will be converted to a double.
     *   * Otherwise, if either of the operands is of type float, the other one will be converted to a float.
     *   * Otherwise, if either of the operands is of type long, the other one will be converted to a long.
     *   * Otherwise, both operands will be converted to an int.
     */
}
