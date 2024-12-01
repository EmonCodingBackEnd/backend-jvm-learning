package com.coding.jvm06.string;


import org.junit.Test;

/**
 * 不同JDK版本intern()方法测试
 */
public class StringInternTest {
    @Test
    public void test1() {
        String s = "ab";
        String s1 = new String("a") + new String("b");
        String s2 = s1.intern();
        System.out.println(s1 == s); // JDK6、JDK7和JDK8：false
        System.out.println(s2 == s); // JDK6、JDK7和JDK8：true
    }

    @Test
    public void test2() {
        String s1 = new String("a") + new String("b");
        String s2 = s1.intern();
        String s = "ab";
        System.out.println(s1 == s); // JDK6：false JDK7和JDK8：true
        System.out.println(s2 == s); // JDK6、JDK7和JDK8：true
    }
}
