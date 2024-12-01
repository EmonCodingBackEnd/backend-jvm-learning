package com.coding.jvm04;

/**
 * 测试解释器模式和JIT编译模式
 * -Xint => 花费的时间为：6834ms
 * -Xcomp => 花费的时间为：651ms
 * -Xmixed => 花费的时间为：759ms
 */
public class IntCompTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        testPrimeNumber(1000000);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "ms");
    }

    private static void testPrimeNumber(int count) {
        for (int i = 0; i < count; i++) {
            // 计算100以内的质数
            label:
            for (int j = 2; j <= 100; j++) {
                for (int k = 2; k < Math.sqrt(j); k++) {
                    if (j % k == 0) {
                        continue label;
                    }
                }
            }

        }
    }
}
