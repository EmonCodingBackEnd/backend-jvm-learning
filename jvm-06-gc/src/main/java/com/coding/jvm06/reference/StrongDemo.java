package com.coding.jvm06.reference;

public class StrongDemo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我被回收了");
    }

    @Override
    public String toString() {
        return "StrongDemo对象";
    }
}
