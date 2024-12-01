package com.coding.jvm01.instruct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 指令8、异常处理
 */
public class ExceptionTest {
    public void throwZero(int i) {
        if (i == 0) {
            throw new RuntimeException("参数值为0");
        }
    }

    public void throwOne(int i) throws RuntimeException, IOException {
        if (i == 1) {
            throw new RuntimeException("参数值为1");
        }
    }

    public void throwArithmetic() {
        int i = 10;
        int j = i / 0;
        System.out.println(j);
    }

    public void tryCatch() {
        try {
            File file = new File("d:/hello.txt");
            FileInputStream fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    // 思考：如下方法返回结果为多少？好好理解一下值传递（对引用类型，传递的对象的地址值）
    public static String func(Item item) {
        String str = "hello";
        try {
            item.setName("hello1");
            return str;
        } finally {
            str = "emon";
            item.setName("emon1");
        }
    }

    public static void main(String[] args) {
        Item item = new Item("aa");
        change(item);
        System.out.println(item); // aa

        System.out.println(func(item)); // hello 不可思议吧
        System.out.println(item); // emon1
    }

    public static void change(Item item) {
        // item = new Item("bb"); // 放开该行，会导致输出 aa，否则是 cc
        item.setName("cc");
    }

    public static class Item {
        private String name;

        public Item(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
