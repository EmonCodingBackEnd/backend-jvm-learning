package com.coding.jvm02.classloader;

/**
 * 查看应用类加载器加载范围
 */
public class AppClassLoaderTest {
    public static void main(String[] args) {
        String pathApp = System.getProperty("java.class.path");
        System.out.println("AppClassLoader 加载范围 开始 --------");
        System.out.println(pathApp.replaceAll(";", System.lineSeparator()));
        System.out.println("AppClassLoader 加载范围 结束 --------");
    }
}
