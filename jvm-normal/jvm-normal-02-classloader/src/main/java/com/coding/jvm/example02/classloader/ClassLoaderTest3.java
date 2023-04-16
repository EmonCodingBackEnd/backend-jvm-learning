package com.coding.jvm.example02.classloader;

public class ClassLoaderTest3 {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader); // null

            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader); // sun.misc.Launcher$AppClassLoader

            ClassLoader classLoader3 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classLoader3); // sun.misc.Launcher$ExtClassLoader
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
