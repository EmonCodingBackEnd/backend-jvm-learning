package com.coding.jvm02.classloader;

/**
 * 查看引导类加载器加载范围
 */
public class BootStrapClassLoaderTest {
    public static void main(String[] args) {
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println("BootStrapClassLoader 加载范围 开始 --------");
        System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));
        System.out.println("BootStrapClassLoader 加载范围 结束 --------");
    }
}
