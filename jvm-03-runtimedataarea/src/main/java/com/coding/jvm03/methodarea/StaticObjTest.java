package com.coding.jvm03.methodarea;

/**
 * 《深入理解Java虚拟机》中的案例：
 * staticObj、instanceObj、localObj存放在哪里？
 */
public class StaticObjTest {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder(); // 静态属性：对象在堆中eden区，变量也在堆中
        ObjectHolder instanceObj = new ObjectHolder(); // 实例属性：对象在堆中eden区，变量也在堆中

        void foo() {
            ObjectHolder localObj = new ObjectHolder(); // 局部变量：对象在堆中eden区，变量在栈帧的局部变量表中
            System.out.println("done");
        }
    }

    private static class ObjectHolder {

    }
}
