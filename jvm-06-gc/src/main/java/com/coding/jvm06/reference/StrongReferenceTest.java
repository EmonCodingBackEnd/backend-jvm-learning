package com.coding.jvm06.reference;

/**
 * 强引用的测试
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        StrongDemo s1 = new StrongDemo();
        StrongDemo s2 = s1;

        s1 = null;
        System.gc();

        try {
            // 3秒的延迟保证GC有时间工作
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        s2 = null;
        System.gc();

        try {
            // 3秒的延迟保证GC有时间工作
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
