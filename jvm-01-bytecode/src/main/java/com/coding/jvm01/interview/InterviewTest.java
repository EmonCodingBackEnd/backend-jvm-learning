package com.coding.jvm01.interview;

import org.junit.Test;

public class InterviewTest {
    @Test
    public void test1() {
        Integer x = 5;
        int y = 5;
        System.out.println(x == y); // true;自动拆箱
    }
}
