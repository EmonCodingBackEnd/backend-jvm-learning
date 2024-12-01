package com.coding.jvm06.string;

/**
 * 使用intern()测试执行效率和空间使用
 * 结论：对于程序中大量存在的字符串，尤其其中存在很多重复字符串时，使用intern()可以提升效率、节省内存
 */
public class StringIntern3 {
    static final int MAX_COUNT = 1000 * 10000;
    static final String[] arr = new String[MAX_COUNT];
    static Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_COUNT; i++) {
            arr[i] = new String(String.valueOf(data[i % data.length])); // 花费的时间为：7370ms 占用的内存：522701400B
//            arr[i] = new String(String.valueOf(data[i % data.length])).intern(); // 花费的时间为：1225ms 占用的内存：115062944B
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("占用的内存：" + (totalMemory - freeMemory));

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
