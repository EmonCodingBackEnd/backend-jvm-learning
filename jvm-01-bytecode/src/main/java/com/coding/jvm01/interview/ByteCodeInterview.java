package com.coding.jvm01.interview;

import org.junit.Test;

public class ByteCodeInterview {
    // 面试题：i++和++i有什么区别？
    @Test
    public void test1() {
        int i = 10;
        i++;
//        ++i;
        System.out.println(i);
    }

    @Test
    public void test2() {
        int i = 10;
        i = i++;
        System.out.println(i); // 10
    }

    @Test
    public void test3() {
        int i = 2;
        i *= i++; // 2 + 2
        System.out.println(i); // 4
    }

    @Test
    public void test4() {
        int k = 10;
        k = k + (k++) + (++k); // 10 + 10 + 12
        System.out.println(k); // 32
    }

    @Test
    public void test5() {
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1 == i2); // true

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4); // false

        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println(b1 == b2); // true
    }

    /**
     * String声明的字面量数据都放在字符串常量池中
     * jdk6中字符串常量池存放在方法区（即永久代中）
     * jdk7及以后字符串常量池存放在堆空间
     */
    @Test
    public void test6() {
        String str = new String("hello") + new String("world");
        str.intern();
        String str1 = "helloworld";
        System.out.println(str == str1); // jdk6:false;jdk7:true，注意：intern调用在str1字面量之前是true，否则是false。
    }
}
