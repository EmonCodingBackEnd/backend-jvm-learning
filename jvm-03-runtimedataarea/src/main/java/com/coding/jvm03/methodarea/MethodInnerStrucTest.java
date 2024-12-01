package com.coding.jvm03.methodarea;

import java.io.Serializable;

/**
 * 测试方法区的内部构成
 * <p>
 * $ javap -v -p MethodInnerStrucTest.class
 * <p>
 * -v  -verbose             输出附加信息
 * -p  -private             显示所有类和成员
 */
public class MethodInnerStrucTest extends Object implements Comparable<String>, Serializable {
    // 属性
    public int num = 10;
    private static String str = "测试方法的内部结构";

    // 构造器
    // 方法
    public void test1() {
        int count = 20;
        System.out.println("count = " + count);
    }

    public static int test2(int cal) {
        int result = 0;
        try {
            int value = 30;
            result = value / cal;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
