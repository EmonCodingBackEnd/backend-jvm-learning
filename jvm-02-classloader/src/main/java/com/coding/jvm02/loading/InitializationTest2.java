package com.coding.jvm02.loading;

/**
 * 过程三：初始化阶段
 * <p>
 * 哪些场景下，java编译器不会生成<clinit>()方法
 */
public class InitializationTest2 {
    // 场景1：一个类中并没有声明任何的类变量，也没有静态代码块时。
    public int num = 1;
    // 场景2：一个类中声明类变量，但是没有明确使用类变量的初始化语句以及静态代码块来执行初始化操作时。
    public static int num2;
    // 场景3：一个类中包含static final修饰的基本数据类型的字段，这些类字段初始化语句采用编译时常量表达式。
    public static final int num3 = 1;
}
