package com.coding.jvm06.string;

/**
 * 字符串不可变
 */
public class StringExer {

    String literal = "good";
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String literal, String str, char ch[]) {
        literal = "test ok";
        str = "test ok";
        ch[0] = 'b';
        System.out.println(literal); // test ok
        System.out.println(str); // test ok
        System.out.println(ch); // {'b', 'e', 's', 't'}
    }

    public static void main(String[] args) {
        StringExer ex = new StringExer();
        ex.change(ex.literal, ex.str, ex.ch);
        System.out.println(ex.literal); // good
        System.out.println(ex.str); // good
        System.out.println(ex.ch); // {'b', 'e', 's', 't'}
    }
}
