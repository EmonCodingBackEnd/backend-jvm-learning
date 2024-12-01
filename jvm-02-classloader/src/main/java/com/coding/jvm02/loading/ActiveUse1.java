package com.coding.jvm02.loading;

import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * 测试类的主动使用：意味着会调用类的<clinit>()，即执行了类的初始化阶段
 * <p>
 * 1. 当创建一个类的实例时，比如使用new关键字，或者通过反射、克隆、反序列化。
 * 2. 当调用类的静态方法时，即当使用了字节码invokestatic指令。
 */
public class ActiveUse1 {
    // new 创建实例
    @Test
    public void test1() {
        Order order = new Order();
    }

    // 反射
    @Test
    public void test2() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        // Order.class.newInstance(); // 方式一
        Class clazz = Class.forName("com.coding.jvm02.loading.Order"); // 方式二
    }

    // 序列化
    @Test
    public void test3_0() throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("order.data")))) {
            oos.writeObject(new Order());
        }
    }

    // 反序列化
    @Test
    public void test3_1() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("order.data")))) {
            Object o = ois.readObject();
        }
    }

    // 当调用类的静态方法时
    @Test
    public void test4() {
        Order.method();
    }

    @Test
    public void test5() {
        // 会主动使用
        System.out.println("test5() 方法执行结果：" + Order.num1);
    }

    @Test
    public void test6() {
        // 不会主动使用
        System.out.println("test6() 方法执行结果：" + Order.num2);
    }

    @Test
    public void test7() {
        // 会主动使用
        System.out.println("test7() 方法执行结果：" + Order.num3);
    }

    @Test
    public void test8() {
        // 不会主动使用
        int num1 = CompareA.NUM1;
    }

    @Test
    public void test9() {
        // 会主动使用
        int num2 = CompareA.NUM2;
    }

}

class Order implements Serializable {
    private static final long serialVersionUID = -6166346450199490389L;

    public static int num1 = 1;
    public static final int num2 = 2;
    public static final int num3 = new Random().nextInt(10);

    static {
        System.out.println("Order类的初始化过程");
    }

    public static void method() {
        System.out.println("Order method()...");
    }

}

interface CompareA {
    Thread t = new Thread() {
        {
            System.out.println("CompareA的初始化");
        }
    };
    int NUM1 = 1;
    int NUM2 = new Random().nextInt(10);
}
