package com.coding.jvm06.relatedconcept;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

/**
 * -XX:+PrintGCDetails
 */
public class LocalVarGC {

    private void printMemInfo() {
        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
            System.out.println(memoryPoolMXBean.getName() + " 已经使用：" + memoryPoolMXBean.getUsage().getUsed() / 1024 / 1024 + "MB" + " 总大小：" +
                    memoryPoolMXBean.getUsage().getCommitted() / 1024 / 1024 + "MB");
        }
    }

    public void localvarGC1() {
        byte[] buffer = new byte[10 * 1024 * 1024]; // 10MB 无法被回收
        printMemInfo();
        System.gc();
        printMemInfo();
    }

    public void localvarGC2() {
        byte[] buffer = new byte[10 * 1024 * 1024]; // 10MB 可以被回收
        buffer = null;
        System.gc();
    }

    public void localvarGC3() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024]; // 10MB 无法被回收
        }
        System.gc();
    }

    public void localvarGC4() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024]; // 10MB 可以被回收
        }
        int value = 10;
        System.gc();
    }

    public void localvarGC5() {
        localvarGC1(); // 无法被回收
        System.gc(); // 可以被回收
    }

    public static void main(String[] args) {
        LocalVarGC localVarGC = new LocalVarGC();
        localVarGC.localvarGC5();
    }
}
