package com.coding.jvm06.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GenerateStringRead {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("words.txt"));
            long start = System.currentTimeMillis();
            String data;
            while ((data = br.readLine()) != null) {
                data.intern(); // 如果字符串常量池中没有对应data的字符串的话，则在常量池中生存
            }
            long end = System.currentTimeMillis();
            /*
             * -XX:StringTableSize=1009 =>109 ms
             * -XX:StringTableSize = 10009 =>51 ms
             */
            System.out.println("花费的时间为：" + (end - start));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
