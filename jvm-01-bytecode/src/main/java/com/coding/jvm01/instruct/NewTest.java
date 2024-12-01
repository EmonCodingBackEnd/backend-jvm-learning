package com.coding.jvm01.instruct;

import java.io.File;

/**
 * 指令4：对象、数组的创建与访问指令
 */
public class NewTest {

    // 1、创建指令
    public void newInstance() {
        Object obj = new Object();
        File file = new File("emon.avi");
    }

    public void newArray() {
        // 创建int数组
        int[] intArray = new int[10];
        // 创建引用类型数组
        Object[] objArray = new Object[10];
        // 创建二位数组
        int[][] mintArray = new int[10][10];
        // 创建没有初始化的二维数组
        String[][] strArray = new String[10][];
    }

    // 2、字段访问指令
    public void sayHello() {
        System.out.println("hello");
    }

    public void setOrderId() {
        Order order = new Order();
        order.id = 1001;
        System.out.println(order.id);

        Order.name = "ORDER";
        System.out.println(Order.name);
    }

    // 3、数组操作指令
    public void setArray() {
        int[] intArray = new int[10];
        intArray[3] = 10;
        System.out.println(intArray[3]);
    }

    public void arrLength() {
        double[] arr = new double[10];
        System.out.println(arr.length);
    }

    // 4、类型检查指令
    public String checkCast(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        } else {
            return null;
        }
    }
}


class Order {
    int id;
    static String name;
}
