package com.coding.jvm06.string;


import org.junit.Test;

public class StringTest5 {

    @Test
    public void test1() {
        String s1 = "a" + "b" + "c"; // 编译器优化：等同于 “abc”
        String s2 = "abc"; // "abc"一定是放在字符串常量池StringTable中，将此地址赋值给s2
        System.out.println(s1 == s2); // true
    }

    @Test
    public void test2() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        // “+”拼接中出现字符串变量等非字面常量，结果都不在 StringTable 中
        String s4 = "javaEE" + new String("hadoop"); // 编译期优化
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // false
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        // intern(): 判断字符串常量池中是否存在 javaEEhadoop 值，如果存在，则返回常量池中概字符串的地址；否则在常量池中加载一份。
        String s8 = s6.intern();
        System.out.println(s3 == s8); // true
    }

    @Test
    public void test3() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        /*
        如下的s1 + s2的执行细节：
        1、StringBuilder s = new StringBuilder();
        2、s.append("a");
        3、s.append("b");
        4、s.toString() --> 类似于 new String("ab")
        补充：在jdk5.0之后使用的是StringBuilder，之前使用的是StringBuffer。
         */
        String s4 = s1 + s2; // s1 + s2 或 s1.concat(s2) 的拼接结果，都不在 StringTable 中
        System.out.println(s3 == s4); // false
    }


    @Test
    public void test4() {
        String s1 = "hello";
        String s2 = "java";
        String s3 = "hellojava";
        String s4 = (s1 + s2).intern();
        String s5 = s1.concat(s2).intern();
        // 拼接后调用intern()方法，结果都在StringTable中
        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // true
    }

    /*
    1、字符串拼接操作不一定使用的是StringBuilder！
    如果拼接符号左右两边都是字符串常量或常量引用，则仍然使用编译期优化，即非StringBuilder方式。
    2、针对于final修饰类、方法、基本数据类型、引用数据类型的量的结构时，能用则用。
     */
    @Test
    public void test5() {
        final String s1 = "hello";
        final String s2 = "java";
        String s3 = "hellojava";
        String s4 = s1 + s2;
        System.out.println(s3 == s4); // true
    }

    // 体会执行效率
    /*
    通过StringBuilder的append()的方式添加字符串的效率要远高于使用String的字符串拼接方式！
    好处1：StringBuilder的append()的方式，自始至终仅创建过一个StringBuilder对象；而String拼接方式创建多个StringBuilder对象和String对象
    好处2：由于内存中创建了过多的StringBuilder和String对象，内存占用更大；如果进行GC，需要花费额外时间！
    改进的空间：在实际开发中，如果基本确定需要前前后后添加的字符串长度不高于某个限定值highLevel的情况下，可以使用构造器直接初始化指定长度的对象。
     */
    @Test
    public void test6() {
        long start = System.currentTimeMillis();
        method2(100000);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));
    }

    // 花费的时间为：3540ms
    private void method1(int highLevel) {
        String src = "";
        for (int i = 0; i < highLevel; i++) {
            src = src + "a"; // 每次循环都会创建一个StringBuilder 和 String
        }
    }

    // 花费的时间为：0
    private void method2(int highLevel) {
        StringBuilder src = new StringBuilder();
        for (int i = 0; i < highLevel; i++) {
            src.append("a");
        }
    }
}
