package com.coding.jvm02;

/**
 * 存在static变量时，通过 jclasslib 查看时才有 clinit 方法。
 */
public class ClinitTest1 {
    private static int num = 1;

    static {
        num = 5;
        number = 20; // linking之prepare: number=0 --> initial: number=20 --> initial: number=10
        // System.out.println(number); // Illegal forward reference
    }
    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClinitTest1.num);
        System.out.println(ClinitTest1.number);
    }
}
