package com.coding.jvm06.gc;

/**
 * -XX:+PrintGCDetails
 */
public class TestSystem {
    public static void main(String[] args) {
        byte[] buffer = new byte[10 * 1024 * 1024];
        buffer = null;
        System.gc(); // 手动触发GC
    }
}
