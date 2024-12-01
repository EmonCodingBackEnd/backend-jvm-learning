package com.coding.jvm02.hotswap;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class MyClassLoader extends ClassLoader {
    private String rootDir;

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String className) {
        Class clazz = this.findLoadedClass(className);
        if (null == clazz) {
            // 获取字节码文件的完整路径
            String classFile = getClassFile(className);
            // 获取输入输出流
            try (FileInputStream fis = new FileInputStream(classFile); FileChannel fileChannel = fis.getChannel();
                 ByteArrayOutputStream baos = new ByteArrayOutputStream(); WritableByteChannel outChannel = Channels.newChannel(baos)) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
                while (true) {
                    int i = fileChannel.read(byteBuffer);
                    if (i == 0 || i == -1) {
                        break;
                    }
                    byteBuffer.flip(); // 修改为读数据模式
                    outChannel.write(byteBuffer);
                    byteBuffer.clear(); // 清空，切换为写模式
                }

                byte[] bytes = baos.toByteArray();
                // 调用defineClass()，将字节数组的数据转换为Class的实例
                clazz = defineClass(null, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return clazz;
    }

    private String getClassFile(String className) {
        return rootDir + "\\" + className.replace('.', '\\') + ".class";
    }
}
