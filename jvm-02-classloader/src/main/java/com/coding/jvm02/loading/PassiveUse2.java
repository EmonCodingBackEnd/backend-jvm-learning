package com.coding.jvm02.loading;

import org.junit.Test;

/**
 * 测试类的被动使用：意味着不会调用类的<clinit>()，即不会进行类的初始化操作。
 * <p>
 * 3. 引用常量不会触发此类或接口的初始化。因为常量在链接阶段的准备环节就已经被显式赋值了。
 * <p>
 * 4. 调用ClassLoader类的loadClass()方法加载一个类，并不是对类的主动使用，不会导致类的初始化。
 * <p>
 * 说明：没有初始化的类，不意味着没有加载
 */
public class PassiveUse2 {


    // 引用常量不会触发此类或接口的初始化。因为常量在链接阶段的准备环节就已经被显式赋值了
    @Test
    public void test1() {
        int num = Person.NUM;
    }

    // 引用常量不会触发此类或接口的初始化。因为常量在链接阶段的准备环节就已经被显式赋值了
    @Test
    public void test2() {
        int num1 = SerialA.NUM1;
    }

    // 调用ClassLoader类的loadClass()方法加载一个类，并不是对类的主动使用，不会导致类的初始化
    @Test
    public void test3() throws ClassNotFoundException {
        ClassLoader.getSystemClassLoader().loadClass("com.coding.jvm02.loading.Person");
    }
}

class Person {
    static {
        System.out.println("Person类的初始化");
    }

    public static final int NUM = 1;
}

interface SerialA {
    Thread t = new Thread() {
        {
            System.out.println("SerialA的初始化");
        }
    };
    int NUM1 = 1;
}
