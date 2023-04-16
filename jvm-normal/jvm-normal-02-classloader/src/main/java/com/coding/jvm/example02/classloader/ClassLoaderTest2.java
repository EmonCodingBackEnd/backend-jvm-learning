package com.coding.jvm.example02.classloader;

import java.net.URL;
import java.security.Provider;

import sun.misc.Launcher;
import sun.security.ec.point.Point;

public class ClassLoaderTest2 {
    public static void main(String[] args) {
        // 获取BootstrapClassLoader能够加载的api的路径
        System.out.println("********启动类加载器********");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
        // 从上面的路径中随意选择一个类，来看看他们的类加载器是什么：引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);// null

        System.out.println("********扩展类加载器********");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        // 从上面的路径中随意选择一个类，来看看他们的类加载器是什么：扩展类加载器
        ClassLoader classLoader1 = Point.class.getClassLoader();
        System.out.println(classLoader1); // sun.misc.Launcher$ExtClassLoader
    }
}
