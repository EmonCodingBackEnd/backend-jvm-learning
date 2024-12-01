package com.coding.jvm06.string;

/**
 * 观察字符串对象个数：
 * Java语言规范里要求完全相同的字符串字面量，应该包含同样的Unicode字符序列（包含同一份码点序列的常量），并且必须是指向同一个String类实例。
 * debug时打开memory面板观察 java.lang.String
 */
public class StringTest4 {

    public static void main(String[] args) {
        String s1 = "hello"; // code(1)1
        String s2 = "hello"; // code(2)
        String s3 = "emon";  // code(3)
    }
}
