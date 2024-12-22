package com.coding.jvm06.gc;

import java.util.ArrayList;

/**
 * -Xms200M
 * -Xmx200M
 * -XX:MetaspaceSize=64M
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -Xloggc:/Users/wenqiu/Misc/gc-oom.log
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=/Users/wenqiu/Misc/heapdump.hprof
 */
public class HeapOOM {
    byte[] buffer = new byte[1 * 1024 * 1024]; // 1MB

    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList<HeapOOM>();

        int count = 0;
        try {
            while (true) {
                list.add(new HeapOOM());
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("count = " + count);
        }
    }
}
