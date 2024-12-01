package com.coding.jvm02.deepinclassloader;

public class UserTest {
    public static void main(String[] args) throws ClassNotFoundException {
//        User user = new User(); // 隐式加载
//
//        Class.forName("com.coding.jvm02.deepinclassloader.User"); // 显式加载
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.coding.jvm02.deepinclassloader.User");// 显式加载
        System.out.println("");
    }
}
