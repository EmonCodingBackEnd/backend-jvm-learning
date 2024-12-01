package com.coding.jvm01.instruct;

/**
 * 补充：方法调用指令的补充说明
 */
public class InterfaceMethodTest {

    public static void main(String[] args) {
        AA aa = new BB();
        aa.method2(); // invokeinterface

        AA.method1(); // invokestatic
    }
}

interface AA {
    public static void method1() {

    }

    public default void method2() {

    }
}

class BB implements AA {

}
