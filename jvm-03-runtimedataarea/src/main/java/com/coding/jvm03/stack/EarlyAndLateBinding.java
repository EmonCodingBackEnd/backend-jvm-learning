package com.coding.jvm03.stack;

/**
 * 早期绑定与晚期绑定
 */
public class EarlyAndLateBinding {
    public void showAnimal(Animal animal) {
        animal.eat(); // 晚期绑定

    }

    public void showHunt(Huntable huntable) {
        huntable.hunt(); // 晚期绑定
    }
}

interface Huntable {
    void hunt();
}

class Animal {
    public void eat() {
        System.out.println("动物进食");
    }
}

class Dog extends Animal implements Huntable {
    @Override
    public void hunt() {
        System.out.println("捕食耗子，多管闲事");
    }

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}

class Cat extends Animal implements Huntable {
    public Cat() {
        super(); // 早期绑定
    }

    public Cat(String name) {
        this(); // 早期绑定
    }

    @Override
    public void hunt() {
        System.out.println("捕食耗子，天经地义");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("猫吃鱼");
    }
}
