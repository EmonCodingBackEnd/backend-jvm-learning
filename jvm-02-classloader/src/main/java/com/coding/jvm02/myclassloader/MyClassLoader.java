package com.coding.jvm02.myclassloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    private String byteCodePath;

    public MyClassLoader(String byteCodePath) {
        this.byteCodePath = byteCodePath;
    }

    public MyClassLoader(ClassLoader parent, String byteCodePath) {
        super(parent);
        this.byteCodePath = byteCodePath;
    }

    @Override
    protected Class<?> findClass(String className) {
        // 获取字节码文件的完整路径
        String fileName = Paths.get(byteCodePath, className + ".class").toString();
        // 获取输入输出流
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get(fileName)));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            // 把字节码读入内存
            int len;
            byte[] data = new byte[1024];
            while ((len = bis.read(data)) != -1) {
                baos.write(data, 0, len);
            }

            // 获取内存中完整的字节数组数据
            byte[] byteCodes = baos.toByteArray();

            // 调用defineClass()，将字节数组的数据转换为Class的实例
            return defineClass(null, byteCodes, 0, byteCodes.length);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
