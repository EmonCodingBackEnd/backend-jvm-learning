package com.coding.jvm03.stack;

/**
 * 虚方法与非虚方法
 */
class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father static " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father 普通方法");
    }
}

public class VirtualAndNonVirtual extends Father {
    public VirtualAndNonVirtual() {
        // invokespecial
        super();
    }

    public VirtualAndNonVirtual(int age) {
        // invokespecial
        this();
    }

    // 不是重写的父类的静态方法，因为静态方法无法被重写
    public static void showStatic(String str) {
        System.out.println("son static " + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private " + str);
    }

    public void show() {
        showStatic("emon.com"); // invokestatic
        super.showStatic("good！"); // invokestatic
        showPrivate("hello!"); // invokespecia
        super.showCommon(); // invokespecia
        showFinal(); // invokevirtual -> 被认为非虚方法，因为无法重载！！！，若是super.showFinal()则是invokespecial
        showCommon(); // invokevirtual
        info(); // invokevirtual

        MethodInterface in = null;
        in.methodA(); // invokeinterface
    }

    public void info() {}

    public void display(Father f) {
        f.showCommon();
    }

    public static void main(String[] args) {
        VirtualAndNonVirtual virtualAndNonVirtual = new VirtualAndNonVirtual();
        virtualAndNonVirtual.show();
    }
}

interface MethodInterface {
    void methodA();
}