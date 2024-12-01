package com.coding.jvm03.stack;

public class SlotTest {
    public void localVar1() {
        int a = 0;
        System.out.println(a);
        int b = 0;
    }

    public void localVar2() {
        {
            int a = 0;
            System.out.println(a);
        }
        // 此时的b就会复用a的槽位
        int b = 0;
    }
}
