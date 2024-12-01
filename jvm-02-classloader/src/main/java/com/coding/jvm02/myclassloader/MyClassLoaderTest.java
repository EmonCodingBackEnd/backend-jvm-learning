package com.coding.jvm02.myclassloader;

public class MyClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("D:");
        try {
            Class<?> clazz = myClassLoader.loadClass("User");
            System.out.println("加载此类的类的加载器为：" + clazz.getClassLoader().getClass().getName());
            System.out.println("加载此类的类加载的父加载器为：" + clazz.getClassLoader().getParent().getClass().getName());
            System.out.println("加载此类的类加载的父加载器的父加载器为：" + clazz.getClassLoader().getParent().getParent().getClass().getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
