package com.coding.jvm03.methodarea;

public class MethodAreaTest {
    public static void main(String[] args) {
        // 惊不惊喜意不意外，不异常
        Order order = null;
        order.hello();
        System.out.println(order.count);
    }
}

class Order {
    // 类加载后赋值
    public static int count = 1;
    // 编译器赋值
    public static final int number = 2;

    public static void hello() {
        System.out.println("hello!");
    }
}