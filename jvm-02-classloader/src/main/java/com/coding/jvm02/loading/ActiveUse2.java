package com.coding.jvm02.loading;

import org.junit.Test;

import java.util.Random;

/**
 * 测试类的主动使用：意味着会调用类的<clinit>()，即执行了类的初始化阶段
 * <p>
 * 4. 当使用java.lang.reflect包中的方法反射类的方法时。比如：Class.forName("com.coding.Test")
 * 5. 当初始化子类时，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
 * 6. 如果一个接口定义了default方法，那么直接实现或者间接实现了该接口的类若初始化，该接口要在其之前被初始化。
 * 7. 当虚拟机启动时，用户需要指定一个要执行的主类（包含 main() 方法的那个类），虚拟机会先初始化这个主类。
 * 8. 当初次调用 MethodHandle 实例时，初始化该 MethodHandle 执行的方法所在的类。（涉及解析 REF_getStatic、REF_pubStatic、REF_invokeStatic方法句柄对应的类）
 * <p>
 * 针对5，补充说明：
 * <p>
 * 当Java虚拟机初始化一个类时，要求它的所有父类都已经被初始化，但是这条规则并不适用于接口。
 * <span style="color:blue;font-weight:bold;">在初始化一个类时，并不会先初始化它所实现的接口。</span>
 * <span style="color:blue;font-weight:bold;">在初始化一个接口时，并不会先初始化它的父接口。</span>
 * 因此，一个父接口并不会因为它的子接口或者实现类的初始化而初始化。只有当程序首次使用特定接口的静态字段时，才会导致该接口的初始化。
 */
public class ActiveUse2 {

    // 当初始化子类时，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化
    // 在初始化一个类时，并不会先初始化它所实现的接口。
    // 如果一个接口定义了default方法，那么直接实现或者间接实现了该接口的类若初始化，该接口要在其之前被初始化
    @Test
    public void test1() {
        int num = Son.num;
    }

    // 在初始化一个接口时，并不会先初始化它的父接口。
    @Test
    public void test2() {
        int num2 = CompareC.NUM1;
    }

    // 当虚拟机启动时，用户需要指定一个要执行的主类（包含 main() 方法的那个类），虚拟机会先初始化这个主类
    static {
        System.out.println("ActiveUse2类的初始化过程");
    }

    public static void main(String[] args) {
        System.out.println("main() 方法执行......");
    }

}

class Father {

    static {
        System.out.println("Father类的初始化过程");
    }
}

class Son extends Father implements CompareB {

    public static int num = 1;

    static {
        System.out.println("Son类的初始化过程");
    }
}

interface CompareB {
    Thread t = new Thread() {
        {
            System.out.println("CompareB的初始化");
        }
    };

    // 如果一个接口定义了default方法，那么直接实现或者间接实现了该接口的类若初始化，该接口要在其之前被初始化
    default void method1() {
        System.out.println("CompareB->method1()");
    }
}

interface CompareC extends CompareB {
    Thread t = new Thread() {
        {
            System.out.println("CompareC的初始化");
        }
    };

    int NUM1 = new Random().nextInt(10);
}

