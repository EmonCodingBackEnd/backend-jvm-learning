package com.coding.jvm07.vmoptions;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;

/**
 * 监控我们的应用服务器的堆内存使用情况，设置一些阈值进行报警等处理。
 */
public class MemoryMonitor {

    public static void main(String[] args) {
        System.out.println("\nAuto Information:");
        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
            System.out.println(memoryPoolMXBean.getName() + " 已经使用：" + memoryPoolMXBean.getUsage().getUsed() / 1024 / 1024 + "MB" + " 总大小：" +
                    memoryPoolMXBean.getUsage().getCommitted() / 1024 / 1024 + "MB");
        }
        System.out.println("\nSome Information:");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("INIT HEAP:" + usage.getInit() / 1024 / 1024 + "m");
        System.out.println("MAX HEAP:" + usage.getMax() / 1024 / 1024 + "m");
        System.out.println("USE HEAP:" + usage.getUsed() / 1024 / 1024 + "m");
        System.out.println("\nFull Information:");
        System.out.println("Heap Memory Usage:" + memoryMXBean.getHeapMemoryUsage());
        System.out.println("Non-Heap Memory Usage:" + memoryMXBean.getNonHeapMemoryUsage());
        System.out.println("\n========================通过Java来获取相关系统状态========================\n");
        System.out.println("当前堆内存大小totalMemory:" + (int) Runtime.getRuntime().totalMemory() / 1024 / 1024 + "m");
        System.out.println("空闲堆内存大小freeMemory:" + (int) Runtime.getRuntime().freeMemory() / 1024 / 1024 + "m");
        System.out.println("最大可用总堆内存maxMemory:" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "m");
    }
}
