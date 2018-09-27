package com.cultivation.javaBasic.demo;

public class Char {
    public static void main(String[] args) {
//        getChar();
//        getByte();
//        getFloat();
//        getInfinity();
//        type();
    }

    private static void type() {
        char a = 'a';
        short b = (short) a;
        int c = a;
        byte e = 12;
        char d = (char) e;
    }

    private static void getInfinity() {
        System.out.println(1 / 0.0); //Infinity
        System.out.println(1 / -0.0); //-Infinity
        System.out.println(0 / 0.0);  //Nan
        System.out.println(Double.compare(1, 2));
        System.out.println(Double.isFinite(1 / 1));
        System.out.println(Double.POSITIVE_INFINITY);
    }

    private static void getFloat() {
        System.out.println(2 * 3);
        double x = 2 * 3.0;
        System.out.println(x);
        float x1 = 2 * 2.0f;
        System.out.println(x1);
        double x2 = 2.3 * 3.0f;
        System.out.println(x2);
        double x3 = 2l * 3.0;
        System.out.println(x3);
    }

    private static void getByte() {
        byte a = 11;
        byte b = 12;
        int i = a + b;
        System.out.println(i);
    }

    private static void getChar() {
        char a = 'a';
        char b = 'b';
        int[] ints = new int[]{1, 2, 3};
        char[] chars = new char[]{'a', 'b'};
        int i = Character.codePointAt(chars, 1);
        int world = "a".compareTo("b");
        String string = Character.toString(a);
        System.out.println(string);
        System.out.println(world);
        System.out.println(i);
        System.out.println(a + b);
    }
}
