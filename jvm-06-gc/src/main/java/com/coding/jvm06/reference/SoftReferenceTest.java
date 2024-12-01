package com.coding.jvm06.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用的测试：内存不足即回收
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 */
public class SoftReferenceTest {

    public static class User {
        public int id;
        public String name;
        private byte[] data = new byte[1024 * 1024];

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        // 创建对象，建立软引用
        SoftReference<User> userSoftRef = new SoftReference<>(new User(1, "emon"));
        // 上面的一行代码，等价于如下的三行代码
        /*User u1 = new User(1, "emon");
        SoftReference<User> userSoftRef = new SoftReference<User>(u1);
        u1 = null; // 取消强引用*/

        // 从软引用中重新获得强引用
        System.out.println(userSoftRef.get());

        System.gc();
        System.out.println("After GC:");
        // 垃圾回收之后获得软引用中的对象，由于堆空间内存足够，所以不会回收软引用的可达对象
        System.out.println(userSoftRef.get());

        try {
            // 让系统认为内存资源紧张
            byte[] b = new byte[1024 * 1024 * 6];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 再次从软引用中获取数据
            System.out.println(userSoftRef.get()); // 在报OOM之前，垃圾回收器会回收软引用的可达对象，已经找不到了
        }
    }
}
