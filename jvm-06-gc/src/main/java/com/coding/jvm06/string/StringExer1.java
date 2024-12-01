package com.coding.jvm06.string;

/**
 *
 */
public class StringExer1 {

    public static void main(String[] args) {
        // 该行代码执行完毕后，字符串常量池中并没有"ab"
        String s = new String("a") + new String("b"); // new String("ab")
        String s2 = s.intern(); // jdk6中：在串池中创建一个字符串"ab"并返回地址给s2  jdk7+中：把new String("ab")对象的引用给串池

        System.out.println(s2 == "ab"); // jdk6:true jdk7+:true
        System.out.println(s == "ab"); // jdk6:false jdk7+:true
    }
}
