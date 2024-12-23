package com.coding.jvm06.string;

/**
 * new String("ab"); 会创建几个对象？看字节码，就知道是两个。
 * 一个对象是：new关键字在堆空间创建的
 * 另一个对象是：字符串常量池中的对象"ab"。字节码指令：ldc
 * <p>
 * new String("a") + new String("b")呢？
 * 对象1：new StringBuilder()
 * 对象2：new String("a")
 * 对象3： ldc 常量池中的"a"
 * 对象4：new String("b")
 * 对象5： ldc 常量池中的"b"
 * 深入剖析：StringBuilder的toString()方法
 * 对象6：new String("ab")
 * 强调一下，toString()的调用，在字符串常量池中，没有生成"ab"
 */
public class StringNewTest {
    public static void main(String[] args) {
        /*
         * +2个String
         */
//        String str1 = new String("ab");
//        String str = "ab";
//        System.out.println(str == str1); // false

        /*
        +4个String：
         */
//        String str2 = new String("a") + new String("b");
        /*
        +5个String
         */
//        String str3 = new String("a") + new String("b") + new String("c");
        /*
        +6个String
         */
        String str4 = new String("a") + new String("b") + new String("c") + new String("d");
        System.out.println("");
    }
}
