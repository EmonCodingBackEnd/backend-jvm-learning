package com.coding.jvm07.gui;

import java.util.ArrayList;

/**
 * -Xms600m -Xmx600m
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:+HeapDumpBeforeFullGC
 * -XX:HeapDumpPath=d:\heapdumpinstance.hprof
 * -XX:OnOutOfMemoryError
 */
public class HeapDumpInstance {
    private static int _1MB = 1024 * 1024;
    byte[] buffer = new byte[10 * _1MB];

    public static void main(String[] args) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<HeapDumpInstance> list = new ArrayList<>();
        for (int i = 0; i < 56; i++) {
            list.add(new HeapDumpInstance());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序执行结束");
    }
}
