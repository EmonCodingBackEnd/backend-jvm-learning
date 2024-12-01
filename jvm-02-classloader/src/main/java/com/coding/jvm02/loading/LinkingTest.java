package com.coding.jvm02.loading;

/**
 * 过程二：链接阶段
 * <p>
 * 基本数据类型：非final修饰的变量，在准备环节进行默认初始化赋值。 final修饰以后，在准备环节直接进行显式赋值。
 * <p>
 * 拓展：如果使用字面量的方式定义一个字符串的常量的话，也是在准备环节直接进行显式赋值。
 */
public class LinkingTest {
    // 定义静态变量id
    private static long id;
    // 定义静态常量num，并且赋值为1
    private static final int num = 1;
//    public static final String constStr = "CONST";
//    public static final String constStr1 = new String("CONST");
//
//    public Object getObj() {
//        return null;
//    }
}
