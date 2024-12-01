package com.coding.jvm07.gui;

import java.util.HashSet;

public class ChangeHashCode1 {
    public static void main(String[] args) {
        HashSet<Point> hs = new HashSet<>();
        Point cc = new Point();
        cc.setX(10); // hashCode = 41
        hs.add(cc);
        cc.setX(20); // hashCode = 51
        System.out.println("hs.remove=" + hs.remove(cc)); // false
        hs.add(cc);
        System.out.println("hs.size=" + hs.size()); // size = 2
        System.out.println(hs);
    }
}

class Point {
    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                '}';
    }
}
