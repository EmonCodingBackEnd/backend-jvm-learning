package com.coding.jvm04;

public class IHaveNatives {
    public native void native1(int x);

    public static native long native2();

    private synchronized native float native3(Object o);

    native void native4(int[] array) throws Exception;
}
