package com.coding.jvm06.string;

public class Memory {
    public static void main(String[] args) { // line1
        int i = 1; // line 2
        Object obj = new Object(); // line3
        Memory mem = new Memory(); // line 4
        mem.foo(obj); // line 5
    } // line 9

    private void foo(Object param) { // line 6
        String str = param.toString(); // line 7
        System.out.println(str);
    } // line 8
}
