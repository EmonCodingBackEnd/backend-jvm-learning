package com.coding.jvm03.heap.escape;

/**
 * 同步省略说明
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        Object hollis = new Object();
        synchronized (hollis) {
            System.out.println(hollis);
        }
    }
}
