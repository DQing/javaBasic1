package com.cultivation.javaBasic.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        getListArray();
        List list = Arrays.asList(1, 2, 3);
        list.add(3);

    }

    private static void getListArray() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        Integer[] objects = stream.toArray(Integer[]::new);
        List<Integer> arrayList = new ArrayList<>();
        Integer[] objects1 = arrayList.toArray(new Integer[0]);
    }
}
