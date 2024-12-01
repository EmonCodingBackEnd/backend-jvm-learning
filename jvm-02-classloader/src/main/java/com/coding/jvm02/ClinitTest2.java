package com.coding.jvm02;

public class ClinitTest2 {

    // 任何一个类声明以后，内部至少存在一个类的构造器
    private int a = 10;
    private static int c = 3;

    public ClinitTest2(int a) {
        this.a = a;
        int d = 20;
    }

    public static void main(String[] args) {
        int b = 2;
    }
}
