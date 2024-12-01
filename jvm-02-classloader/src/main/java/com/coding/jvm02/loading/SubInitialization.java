package com.coding.jvm02.loading;

public class SubInitialization extends InitializationTest {
    static {
        number = 4;
        System.out.println("son static{}");
    }

    public static void main(String[] args) {
        System.out.println(number); // 4
    }
}
