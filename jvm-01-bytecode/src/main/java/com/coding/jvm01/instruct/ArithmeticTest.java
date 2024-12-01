package com.coding.jvm01.instruct;

import org.junit.Test;

/**
 * 2、算术指令
 */
public class ArithmeticTest {

    public void method1() {
        int i = 10;
        i++;
    }

    public void method2() {
        int i = 10;
        ++i;
    }

    public void method3() {
        int i = 10;
        int a = i++;
        int j = 20;
        int b = ++j;
    }

    @Test
    public void method11() {
        int i = 10;
        double j = i / 0.0;
        System.out.println(j); // Infinity

        double d1 = 0.0;
        double d2 = d1 / 0.0;
        System.out.println(d2); // NaN

        System.out.println(0 / 0.0); // NaN
    }

    public void method21() {
        float i = 10;
        float j = -1;
        i = -j;
    }

    public void method31(int j) {
        int i = 100;
        // i = i + 10;
        i += 10;
    }

    public int method41() {
        int a = 80;
        int b = 7;
        int c = 10;
        return (a + b) * c;
    }

    public int method51(int i, int j) {
        return ((i + j - 1) & ~(j - 1));
    }

    // 关于（前）++和（后）++
    public void method61() {
        int i = 10;
//        i++;
        ++i;
    }

    public void method71() {
        int i = 10;
        int a = i++;

        int j = 20;
        int b = ++j;
    }

    // 思考
    @Test
    public void method81() {
        int i = 10;
        i = i++; // 10
        // i = ++i; // 11
        System.out.println(i); // 10 不可思议吧
    }

}
