package com.coding.jvm03.methodarea.directmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 该参数对反射方式是无效的
 * -Xmx20m -XX:MaxDirectMemorySize=10m
 */
public class MaxDirectMemorySizeTest {
    private static final int _1MB = 1024 * 1024; // 1MB

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
