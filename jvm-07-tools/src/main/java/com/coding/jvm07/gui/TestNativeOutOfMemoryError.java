package com.coding.jvm07.gui;

import java.util.concurrent.CountDownLatch;

public class TestNativeOutOfMemoryError {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            System.out.println("i=" + i);
            new Thread(new HoldThread()).start();
        }
    }
}

class HoldThread extends Thread {
    CountDownLatch cd1 = new CountDownLatch(1);

    @Override
    public void run() {
        try {
            cd1.await();
        } catch (InterruptedException e) {
        }
    }
}