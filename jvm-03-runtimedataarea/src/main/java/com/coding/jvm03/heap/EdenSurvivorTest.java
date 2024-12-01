package com.coding.jvm03.heap;

// @formatter:off
/**
 * VM options:  -Xms600m -Xmx600m
 * 打开工具 jvisualvm
 * 
 * 默认`-XX:NewRatio=2`，表示新生代占1，老年代占2，新生代占整个堆的1/3
 * $ jinfo -flag NewRatio 7684
 * -XX:NewRatio=2
 * $jinfo -flag SurvivorRatio 7684
 * -XX:SurvivorRatio=8  默认情况下实际发现是6，主动配置了8才是真的8.
 *
 * -XX:-UseAdaptiveSizePolicy 关闭自适应内存分配策略（暂时用不到）
 * -Xmn 设置新生代空间的大小，一般不设置；优先级比 -XX:NewRatio 高。
 */
// @formatter:on

public class EdenSurvivorTest {
    public static void main(String[] args) {
        System.out.println("我只是来打个酱油~");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}