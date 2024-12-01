package com.coding.jvm01.interview;

import java.util.Comparator;

public class MethodInvokeTest {
    public static void main(String[] args) {
        Father2 f = new Father2();
        Son2 s = new Son2();
        System.out.println(f.getInfo());
        System.out.println(s.getInfo());
        Son2.show();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        comparator = Integer::compare; // invokedynamic
//        comparator.compare(12, 32); // invokeinterface
    }
}

class Father2 {
    private String info = "emon";

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

class Son2 extends Father2 {
    private String info = "问秋";

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }

    public static void show() {
        System.out.println("hello");
    }
}
