package com.coding.jvm03.heap;

// @formatter:off
/**
 * -Xms 用来设置堆空间（年轻代+老年代）的初始内存大小 -X=>是jvm的运行参数 ms=>是memory start
 *
 * -Xmx 用来设置堆空间（年轻代+老年代）的最大内存大小 -X=>是jvm的运行参数 mx=>是memory max
 *
 * VM options:  -Xms600m -Xmx600m
 *
 * 如何查看设置的参数？
 * 方式一： jps => jstat -gc 进程id
 * S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT
 * 25600.0 25600.0  0.0    0.0   153600.0 12288.3   409600.0     0.0       -      -      -      -         0    0.000   0      0.000    0.000
 * S0C+S1C+EC+OC=600m
 * S0C/S1C+EC+OC=575m 因为S0C和S1C同一时刻只会使用1个
 * 方式二： -XX:+printGCDetails
 Heap
 PSYoungGen      total 179200K, used 12288K [0x00000000f3800000, 0x0000000100000000, 0x0000000100000000)
 eden space 153600K, 8% used [0x00000000f3800000,0x00000000f4400178,0x00000000fce00000)
 from space 25600K, 0% used [0x00000000fe700000,0x00000000fe700000,0x0000000100000000)
 to   space 25600K, 0% used [0x00000000fce00000,0x00000000fce00000,0x00000000fe700000)
 ParOldGen       total 409600K, used 0K [0x00000000da800000, 0x00000000f3800000, 0x00000000f3800000)
 object space 409600K, 0% used [0x00000000da800000,0x00000000da800000,0x00000000f3800000)
 PSPermGen       total 21504K, used 2921K [0x00000000d5600000, 0x00000000d6b00000, 0x00000000da800000)
 object space 21504K, 13% used [0x00000000d5600000,0x00000000d58da668,0x00000000d6b00000)
 */
// @formatter:on
public class HeapSpaceInitial {
    public static void main(String[] args) {
        // 返回Java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1204;
        // 返回Java虚拟机试图使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms:" + initialMemory + "M");
        System.out.println("-Xms:" + maxMemory + "M");

        System.out.println("系统内存大小为：" + initialMemory * 64.0 / 1024 + "G");
        System.out.println("系统内存大小为：" + maxMemory * 4.0 / 1024 + "G");

        /*try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
