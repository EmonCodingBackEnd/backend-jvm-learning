package com.coding.jvm06.string;


import org.junit.Test;

/**
 * String的基本使用：体现String的不可变性。
 */
public class StringTest1 {

    @Test
    public void test1() {
        String s1 = "java"; // 字面量定义的方式，"abc"存储在字符串常量池中。
        String s2 = "java";
        s1 = "hello";
        System.out.println(s1); // hello
        System.out.println(s2); // java
    }

    @Test
    public void test2() {
        String s1 = "java"; // 字面量定义的方式，"abc"存储在字符串常量池中。
        String s2 = s1 + "hello";
        System.out.println(s1); // java
        System.out.println(s2); // javahello
    }

    @Test
    public void test3() {
        String s1 = "java";
        String s2 = s1.concat("hello");
        System.out.println(s1); // java
        System.out.println(s2); // javahello
    }

    @Test
    public void test4() {
        String s1 = "java";
        String s2 = s1.replace('a', 'A');
        System.out.println(s1); // java
        System.out.println(s2); // jAvA
    }
}
