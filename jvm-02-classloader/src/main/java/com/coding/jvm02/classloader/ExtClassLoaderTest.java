package com.coding.jvm02.classloader;

/**
 * 查看扩展类加载器加载范围
 */
public class ExtClassLoaderTest {
    public static void main(String[] args) {
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println("ExtClassLoader 加载范围 开始 --------");
        System.out.println(pathExt.replaceAll(";", System.lineSeparator()));
        System.out.println("ExtClassLoader 加载范围 结束 --------");
    }
}
