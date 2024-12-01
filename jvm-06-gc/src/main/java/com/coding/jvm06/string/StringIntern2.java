package com.coding.jvm06.string;

public class StringIntern2 {

    public static void main(String[] args) {
        String s1 = new String("1");  // 会创建字符串常量池对象"1"
        String s2 = s1.intern();
        System.out.println(s1 == s2); // false

        String s4 = new String("1") + new String("1"); // jdk1.7+:不会创建字符串常量池对象"11"
        String s5 = s4.intern(); // jdk1.7+:创建字符串常量池对象"11"，并返回此(s4)对象的引用给s5
        System.out.println(s4 == s5); // jdk1.7+:true
    }
}
