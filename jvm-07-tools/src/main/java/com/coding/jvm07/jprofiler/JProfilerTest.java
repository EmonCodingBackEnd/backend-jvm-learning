package com.coding.jvm07.jprofiler;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 功能演示测试：正常程序
 */
public class JProfilerTest {
    public static void main(String[] args) {
        while (true) {
            ArrayList list = new ArrayList();
            for (int i = 0; i < 500; i++) {
                Data data = new Data();
                list.add(data);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Data {
    private int size = 10;
    private byte[] buffer = new byte[1024 * 1024]; // 1mb
    private String info = "hello,world";
}
