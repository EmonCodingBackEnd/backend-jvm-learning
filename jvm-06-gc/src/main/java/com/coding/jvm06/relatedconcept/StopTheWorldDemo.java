package com.coding.jvm06.relatedconcept;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StopTheWorldDemo {

    public static class WorkThread extends Thread {
        List<byte[]> list = new ArrayList<byte[]>();

        @Override
        public void run() {
            try {
                while (true) {
                    for (int i = 0; i < 1000; i++) {
                        byte[] buffer = new byte[1024 * 256]; // 若不明显，可以增加这里的byte数组大小
                        list.add(buffer);
                    }

                    if (list.size() > 10000) {
                        list.clear();
                        System.gc(); // 会触发full gc，进而会出现STW事件
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class PrintThread extends Thread {
        SimpleDateFormat s = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH:mm:ss");

        @Override
        public void run() {
            try {
                while (true) {
                    // 每秒打印时间信息
                    String str = s.format(new Date());
                    System.out.println(str);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WorkThread w = new WorkThread();
        PrintThread p = new PrintThread();
        w.start();
        p.start();
    }
}
