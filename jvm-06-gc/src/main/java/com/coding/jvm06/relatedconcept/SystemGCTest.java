package com.coding.jvm06.relatedconcept;

public class SystemGCTest {
    public static void main(String[] args) {
        new SystemGCTest();
        // Runtime.getRuntime().gc(); 与 System.gc() 一样
        System.gc(); // 提醒jvm的垃圾回收器执行gc，但并不一定执行

        System.runFinalization(); // 强制调用失去引用的对象的finalize()方法
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest 重写了 finalize()");
    }
}
