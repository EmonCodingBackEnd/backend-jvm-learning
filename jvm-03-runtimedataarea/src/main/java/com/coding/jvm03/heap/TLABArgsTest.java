package com.coding.jvm03.heap;

/**
 * 测试 -XX:UseTLAB 是否开启的情况：默认情况是开启的
 * 打开工具 jvisualvm
 *
 * $ jinfo -flag UseTLAB 17284
 * -XX:+UseTLAB
 */
public class TLABArgsTest {
    public static void main(String[] args) {
        System.out.println("我只是来打个酱油~");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
