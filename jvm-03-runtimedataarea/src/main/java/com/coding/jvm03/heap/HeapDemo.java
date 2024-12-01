package com.coding.jvm03.heap;

// @formatter:off
/**
 * 启动实例1：   VM options:  -Xms10m -Xmx10m
 * 启动实例2：   VM options:  -Xms20m -Xmx20m
 * 启动 jvisualvm 工具
 */
// @formatter:on
public class HeapDemo {

    public static void main(String[] args) {
        System.out.println("start......");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end......");
    }
}
