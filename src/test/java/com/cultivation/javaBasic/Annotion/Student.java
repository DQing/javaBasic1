package com.cultivation.javaBasic.Annotion;

import com.cultivation.javaBasic.util.MyAnnotation;

public class Student {
    static int a;

    @MyAnnoation
    public String getName() {
        return "Douqing";
    }


    public int getAge() {
        return 20;
    }

    public static void main(String[] args) {
        a = 10;
        System.out.println(a);
    }
}
