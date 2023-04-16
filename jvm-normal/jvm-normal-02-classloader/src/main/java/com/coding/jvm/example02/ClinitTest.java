package com.coding.jvm.example02;

public class ClinitTest {

    // 任何一个类声明以后，内部至少存在一个类的构造器
    private int a = 10;
    private static int c = 3;

    public ClinitTest(int a) {
        this.a = a;
        int d = 20;
    }

    public static void main(String[] args) {
        int b = 2;
    }
}
