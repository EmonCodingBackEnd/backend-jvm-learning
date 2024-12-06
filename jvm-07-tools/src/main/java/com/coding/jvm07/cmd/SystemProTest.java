package com.coding.jvm07.cmd;

import java.util.Properties;

public class SystemProTest {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        String[] split = properties.toString().split(",");
        for (String str : split) {
            System.out.println(str);
        }
    }
}
