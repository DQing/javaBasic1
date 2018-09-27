package com.cultivation.javaBasic.Annotion;

import com.cultivation.javaBasic.util.MyAnnotation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AnnotationTest {
    @Test
    void should_test_annotation() {
        String[] annotations = Arrays.stream(Student.class.getDeclaredMethods())
                .filter(method -> method.getAnnotation(MyAnnoation.class) != null)
                .map(Method::getName)
                .toArray(String[]::new);
        String[] excepted = new String[]{"getName"};
        assertArrayEquals(excepted, annotations);
    }
}


