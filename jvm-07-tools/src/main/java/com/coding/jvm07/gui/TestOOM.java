package com.coding.jvm07.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestOOM {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(UUID.randomUUID().toString().intern());
                i++;
            }
        } catch (Exception e) {
            System.out.println("********i:" + i);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public static void test2() {
        Integer i = 0;
        String str = "";
        try {
            while (true) {
                str += UUID.randomUUID();
                i++;
            }
        } catch (Exception e) {
            System.out.println("********i:" + i);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
