package com.coding.jvm02.loading;

import org.junit.Test;

/**
 * 测试类的被动使用：意味着不会调用类的<clinit>()，即不会进行类的初始化操作。
 * <p>
 * 1. 当访问一个静态字段时，只有真正声明这个字段的类才会被初始化。
 * - 当通过子类引用父类的静态变量，不会导致子类初始化。
 * 2. 通过数组定义类引用，不会触发此类的初始化。
 * 3. 引用常量不会触发此类或接口的初始化。因为常量在链接阶段就已经被显式赋值了。
 * <p>
 * 4. 调用ClassLoader类的loadClass()方法加载一个类，并不是对类的主动使用，不会导致类的初始化。
 * <p>
 * 说明：没有初始化的类，不意味着没有加载
 */
public class PassiveUse1 {

    // 当通过子类引用父类的静态变量，不会导致子类初始化。
    @Test
    public void test1() {
        System.out.println(Child.num);
    }

    // 通过数组定义类引用，不会触发此类的初始化
    @Test
    public void test2() {
        Parent[] parents = new Parent[10];
        System.out.println(parents.getClass());
    }

    @Test
    public void test3() {
        Parent[] parents = new Parent[10];
        System.out.println(parents.getClass());
        parents[0] = new Parent(); // 会导致初始化
    }
}

class Parent {
    static {
        System.out.println("Parent的初始化过程");
    }

    public static int num = 1;
}

class Child extends Parent {
    static {
        System.out.println("Child的初始化过程");
    }
}
