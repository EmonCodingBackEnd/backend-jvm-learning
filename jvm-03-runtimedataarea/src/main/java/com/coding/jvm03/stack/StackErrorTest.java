package com.coding.jvm03.stack;

/**
 * 演示栈中的异常
 * 
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class StackErrorTest {
    private static int count = 1; // 默认（每个机器不一样）到 9794，设置 -Xss256k 后到 2251 触发异常

    public static void main(String[] args) {
        System.out.println(count++);
        main(args);
    }
}
