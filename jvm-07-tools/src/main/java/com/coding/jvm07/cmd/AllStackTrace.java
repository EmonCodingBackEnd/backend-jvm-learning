package com.coding.jvm07.cmd;

import java.util.Map;
import java.util.Set;

public class AllStackTrace {
    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> all = Thread.getAllStackTraces();
        Set<Map.Entry<Thread, StackTraceElement[]>> entries = all.entrySet();
        for (Map.Entry<Thread, StackTraceElement[]> entry : entries) {
            Thread t = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            System.out.println("【Thread name is :" + t.getName() + "】");
            for (StackTraceElement stackTraceElement : value) {
                System.out.println("\t" + stackTraceElement.toString());
            }
        }
    }
}
