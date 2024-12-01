package com.coding.jvm06.string;

import org.junit.Test;

public class StringConcatTimeTest {
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        String src = "";
        for (int i = 0; i < 100000; i++) {
            src = src + "a"; // 每次循环都会创建一个 StringBuilder、String
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start)); // 4080ms
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("占用的内存：" + (totalMemory - freeMemory)); // 137506160B
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        // 只需要创建一个 StringBuilder
        StringBuilder src = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            src.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start)); // 16
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("占用的内存：" + (totalMemory - freeMemory)); // 10653712B
    }
}
