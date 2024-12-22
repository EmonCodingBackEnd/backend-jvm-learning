package com.coding.jvm07.gui;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

/**
 * -Xms60M
 * -Xmx60M
 * -Xss512K
 * -XX:SurvivorRatio=8
 * -XX:MetaspaceSize=60M
 * -XX:MaxMetaspaceSize=60M
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -Xloggc:/Users/wenqiu/Misc/metaspace-oom.log
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=/Users/wenqiu/Misc/metaspacedump.hprof
 * -XX:+TraceClassLoading
 * -XX:+TraceClassUnloading
 */
public class MetaspaceOOM {

    public static void main(String[] args) throws InterruptedException {
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(People.class);
            enhancer.setUseCache(true); // => enhancer.setUseCache(true);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
                System.out.println("我是加强类哦，输出print之前的加强方法");
                return methodProxy.invokeSuper(o, objects);
            });
            People people = (People) enhancer.create();
            people.print();
            System.out.println(people.getClass());
            System.out.println("totalClass:" + classLoadingMXBean.getTotalLoadedClassCount());
            System.out.println("activeClass:" + classLoadingMXBean.getLoadedClassCount());
            System.out.println("unloadedClass:" + classLoadingMXBean.getUnloadedClassCount());
        }

    }
}

class People {
    public void print() {
        System.out.println("我是 print 本人");
    }
}
