package com.cultivation.javaBasic.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Consumer {
    @Test
    void name() {
        int[] intWithThree = {1, 2, 3};
        int[] intWithTwo = {1, 2};
        int[] intWithOne = {1};
        Counsumer counsumer = (array) -> {
            if (array.length > 1) {
                int indexOne = array[0];
                array[0] = array[1];
                array[1] = indexOne;
            }
        };
        counsumer.accept(intWithThree);
        counsumer.accept(intWithTwo);
        counsumer.accept(intWithOne);
        assertArrayEquals(new int[]{2, 1, 3}, intWithThree);
        assertArrayEquals(new int[]{2, 1}, intWithTwo);
        assertArrayEquals(new int[]{1}, intWithOne);

    }

    @Test
    void should_get_array_sum() {
        Summer summer = (array) -> {
            if (array == null) {
                return 0;
            }
            return Arrays.stream(array).reduce(0, (left, right) -> left + right);
        };
        assertEquals(0, summer.sum(null));
        assertEquals(1, summer.sum(new int[]{1}));
        assertEquals(6, summer.sum(new int[]{1, 2, 3}));

    }
}


interface Summer {
    int sum(int[] array);
}


interface Counsumer {
    void accept(int[] ints);
}
