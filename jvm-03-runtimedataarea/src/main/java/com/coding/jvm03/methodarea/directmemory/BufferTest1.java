package com.coding.jvm03.methodarea.directmemory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest1 {
    private static final int _100Mb = 1024 * 1024 * 100; // 100MB

    public static void main(String[] args) {
        long sum = 0;
        String src = "D:\\test\\毒液最后yi舞_HD英语中字.mp4";
        for (int i = 0; i < 3; i++) {
            String dest = "D:\\test\\毒液最后yi舞_HD英语中字" + i + ".mp4";
//            sum += io(src, dest);
            sum += directBuffer(src, dest);
        }
        System.out.println("总花费的时间为：" + sum);
    }

    private static long io(String src, String dest) {
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest);) {
            // 定义缓冲区 allocate分配大小
            byte[] buffer = new byte[_100Mb];
            while (true) {
                int len = fis.read(buffer);
                if (len == -1) {
                    break;
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long directBuffer(String src, String dest) {
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(src); FileChannel inChannel = fis.getChannel();
             FileOutputStream fos = new FileOutputStream(dest); FileChannel outChannel = fos.getChannel()) {
            // 定义缓冲区 allocate分配大小
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100Mb);
            while (inChannel.read(byteBuffer) != -1) {
                byteBuffer.flip(); // 修改为读数据模式
                outChannel.write(byteBuffer);
                byteBuffer.clear(); // 清空，切换为写模式
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
