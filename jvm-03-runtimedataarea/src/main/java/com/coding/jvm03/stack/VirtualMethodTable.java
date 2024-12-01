package com.coding.jvm03.stack;

/**
 * 虚拟方法表
 */
public class VirtualMethodTable {}

interface Friendly {
    void sayHello();

    void sayGoodbye();
}

class Dog0 {
    public void sayHello() {

    }

    public String toString() {
        return "Dog";
    }
}

class Cat0 implements Friendly {
    public void eat() {}

    public void sayHello() {}

    public void sayGoodbye() {}

    protected void finalize() {}

    @Override
    public String toString() {
        return "Cat0{}";
    }
}

class CockerSpaniel extends Dog0 implements Friendly {

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public void sayGoodbye() {

    }
}