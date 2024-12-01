package com.coding.jvm02.loading;

import com.coding.jvm02.hotswap.MyClassLoader;

public class ClassUsing {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过类加载器加载Order类java.lang.Class对象
        MyClassLoader myClassLoader = new MyClassLoader("d:/");
        Class clazz = myClassLoader.loadClass("Order");
        // 获取java.lang.Class对象
        Class<Order> orderClass = Order.class;
        // 获取类加载器
        ClassLoader classLoader = orderClass.getClassLoader();
        // 通过实例对象获取java.lang.Class对象
        Order order = new Order();
        Class<? extends Order> aClass = order.getClass();
    }
}
