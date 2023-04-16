package com.coding.jvm.example01;

/**
 * 查看字节码： 方式1：进入 /target/classes/com/coding/jvm/example01 javap -v StackStruTest.class
 *
 * 方式2：安装 jclasslib Bytecode Viewer 插件，然后点击 View -> Show Bytecode With Jclasslib
 *
 */
public class StackStruTest {
    public static void main(String[] args) {
        // int i = 2 + 3;
        int i = 2;
        int j = 3;
        int k = i + j;
    }
}
