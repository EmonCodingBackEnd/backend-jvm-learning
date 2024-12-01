package com.coding.jvm02.classloader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        // 获取当前类的类加载器 sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("获取当前类的类加载器=" + classLoader);
        // 获取当前线程的上下文加载器 sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("获取当前线程的上下文加载器=" + contextClassLoader);
        // 获取系统类加载器 sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("获取系统类加载器=" + systemClassLoader);
        // 获取扩展类加载器 sun.misc.Launcher$ExtClassLoader@14ae5a5
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("获取扩展类加载器=" + extClassLoader);
        // 获取引导类加载器 null
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("获取引导类加载器=" + bootstrapClassLoader);

        // String类使用引导类加载器进行加载的 ---> Java的核心类库都是使用引导类加载器进行加载的
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader); // null
        try {
            ClassLoader stringForNameClassLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(stringForNameClassLoader); // null
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // 关于数组类型的加载：使用的类加载器与元素的类加载器相同
        String[] strArr = new String[6];
        System.out.println(strArr.getClass()); // class [Ljava.lang.String;
        System.out.println(strArr.getClass().getClassLoader()); // null 表示使用的是引导类加载器

        ClassLoaderTest[] arr = new ClassLoaderTest[6]; // class [Lcom.coding.jvm02.classloader.ClassLoaderTest;
        System.out.println(arr.getClass());
        System.out.println(arr.getClass().getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2 表示使用的是系统类加载器

        int[] arr2 = new int[6];
        System.out.println(arr2.getClass().getClassLoader()); // null 表示没有类加载器
    }
}
