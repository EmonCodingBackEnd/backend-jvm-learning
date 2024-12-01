package com.coding.jvm07.cmd;

/**
 * 演示线程： TIMED_WAITING
 */
public class ThreadSleepTest {
    public static void main(String[] args) {
        System.out.println("hello - 1");
        try {
            Thread.sleep(1000 * 60 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello - 2");
    }
}
