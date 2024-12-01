package com.coding.jvm06.string;

import org.junit.Test;

public class StringExer2 {

    @Test
    public void test() {
        // 该行代码执行完毕后，字符串常量池中并没有"ab"
        String s1 = new String("a") + new String("b");
        s1.intern();

        String s2 = "ab";
        System.out.println(s1 == s2); // true
    }

    @Test
    public void test2() {
        // 该行代码执行完毕后，字符串常量值重生成了"ab"
        String s1 = new String("ab");
        s1.intern();

        String s2 = "ab";
        System.out.println(s1 == s2); // false
    }

}
