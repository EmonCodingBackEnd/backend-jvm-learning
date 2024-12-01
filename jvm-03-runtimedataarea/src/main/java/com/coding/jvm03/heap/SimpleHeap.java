package com.coding.jvm03.heap;

/**
 * View -> Show Bytecode With Jclasslib
 *
 * VM options:  -Xms10m -Xmx10 -XX:+printGCDetails
 */
public class SimpleHeap {
    private int id;

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show() {
        System.out.println("My ID is " + id);
    }

    public static void main(String[] args) {
        SimpleHeap s1 = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);
        int[] arr = new int[10];
        Object[] arr1 = new Object[10];
    }
}
