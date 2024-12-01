package com.coding.jvm06.string;

/**
 * <p>
 * -- jdk6
 * $ jinfo -flag StringTableSize pid
 * -XX:StringTableSize=1009
 * -- jdk7
 * $ jinfo -flag StringTableSize pid
 * -XX:StringTableSize=60013
 * -- jdk8
 * $ jinfo -flag StringTableSize pid
 * -XX:StringTableSize=60013
 * -- jdk11
 * $ jinfo -flag StringTableSize pid
 * -XX:StringTableSize=65536
 */
public class StringTest2 {
    public static void main(String[] args) {
        // 测试StringTableSize参数
        System.out.println("我来打个酱油");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
