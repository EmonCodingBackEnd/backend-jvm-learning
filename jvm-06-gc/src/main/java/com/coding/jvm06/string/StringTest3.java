package com.coding.jvm06.string;

import java.util.ArrayList;

/**
 * <p>
 * -- jdk6
 * -XX:PermSize=20m -XX:MaxPermSize=20m -Xms128m -Xmx256m
 * Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
 * <p>
 * -- jdk7
 * -XX:PermSize=20m -XX:MaxPermSize=20m -Xms128m -Xmx256m
 * Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
 * <p>
 * -- jdk8
 * -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=20m -Xms128m -Xmx256m
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
public class StringTest3 {
    public static void main(String[] args) {
        // 使用list保持着常量池引用，避免full gc回收常量池行为
        ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
