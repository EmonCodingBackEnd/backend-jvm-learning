package com.coding.jvm07.jprofiler;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {

    static List list = new ArrayList<>();

    public void oomTests() {
        Object obj = new Object(); // 局部变量
        list.add(obj);
    }
}

