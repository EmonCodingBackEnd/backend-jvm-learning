package com.coding.jvm03.methodarea;

/**
 * 测试设置方法区大小参数的默认值
 * VM options: -Xms600m -Xmx600m
 * jdk7及以前：
 * ‑XX:PermSize=100m ‑XX:MaxPermSize=100m
 * jdk8及以后：
 * -XX:MetaspaceSize=100m -XX:MaxMetaspaceSize=100m
 * <p>
 * $ jinfo -flag PermSize 12516
 * -XX:PermSize=21757952=20.75M
 * $ jinfo -flag MaxPermSize 12516
 * -XX:MaxPermSize=85983232=82M
 * <p>
 * $ jinfo -flag MetaspaceSize 6148
 * -XX:MetaspaceSize=21807104=20.79
 * $ jinfo -flag MaxMetaspaceSize 6148
 * -XX:MaxMetaspaceSize=18446744073709486080
 */
public class MethodAreaDemo {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
