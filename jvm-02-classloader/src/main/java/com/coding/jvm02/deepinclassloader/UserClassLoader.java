package com.coding.jvm02.deepinclassloader;

import java.io.*;

public class UserClassLoader extends ClassLoader {
    private String rootDir;

    public UserClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    /**
     * 编写findClass方法的逻辑
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的class文件字节数组
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            // 知己诶生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 编写获取class文件并转换为字节码流的逻辑
     *
     * @param className
     * @return
     */

    private byte[] getClassData(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            // 读取类文件的字节码
            while ((len = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类文件的完全路径
     *
     * @param className
     * @return
     */
    private String classNameToPath(String className) {
        return rootDir + "\\" + className.replace('.', '\\') + ".class";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String rootDir = "C:\\Job\\JobResource\\IdeaProjects\\backend-jvm-learning\\jvm-02-classloader\\src\\main\\java";

        // 创建自定义类加载器1
        UserClassLoader loader1 = new UserClassLoader(rootDir);
        Class<?> clazz1 = loader1.findClass("com.coding.jvm02.deepinclassloader.User");

        // 创建自定义类加载器2
        UserClassLoader loader2 = new UserClassLoader(rootDir);
        Class<?> clazz2 = loader2.findClass("com.coding.jvm02.deepinclassloader.User");

        System.out.println(clazz1 == clazz2); // clazz1 与 clazz2 对应了不同的类模板结构
        System.out.println(clazz1.getClassLoader());
        System.out.println(clazz2.getClassLoader());

        Class<?> clazz3 = ClassLoader.getSystemClassLoader().loadClass("com.coding.jvm02.deepinclassloader.User");
        System.out.println(clazz3.getClassLoader());
    }
}
