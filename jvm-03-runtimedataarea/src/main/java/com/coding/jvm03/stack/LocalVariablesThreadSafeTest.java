package com.coding.jvm03.stack;

// @formatter:off

import java.util.concurrent.TimeUnit;

/**
 * 方法中定义的局部变量是否线程安全？具体情况具体分析！！！
 *
 * 何为线程安全？
 *  如果只有一个线程才可以操作此数据，则必定是线程安全的。
 *  如果有多个线程操作此数据，则此数据是共享数据。如果不考虑同步机制，则会存在线程安全问题。
 *
 *  View -> Show Bytecode With Jclasslib观察字节码
 */
// @formatter:on

public class LocalVariablesThreadSafeTest {
    /**
     * 线程安全的
     */
    public static void method1() {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
    }

    /**
     * 非线程安全的
     * 
     * @param sb
     */
    public static void method2(StringBuilder sb) {
        sb.append("a");
        sb.append("b");
    }

    /**
     * 有可能是线程不安全的，因为把sb变量返回出去，可以被外部引用了。
     */
    public StringBuilder method3() {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        return sb;
    }

    /**
     * 是线程安全的，返回的是String，而不是StringBuilder。
     */
    public String method4() {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        final StringBuilder s = new StringBuilder();
        new Thread(new Runnable() {
            @Override
            public void run() {
                s.append("a");
                s.append("b");
            }
        }).start();
        method2(s);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(s);
    }
}
