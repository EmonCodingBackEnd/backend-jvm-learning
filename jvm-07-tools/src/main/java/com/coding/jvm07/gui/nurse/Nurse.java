package com.coding.jvm07.gui.nurse;

import java.util.ArrayList;
import java.util.List;

/**
 * 护士人员
 */
public class Nurse {
    private int id;
    private String name;
    private List<People> history = new ArrayList<>();

    public Nurse(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getHistory() {
        return history;
    }

    public void setHistory(List<People> history) {
        this.history = history;
    }

    public void inject(People wp) {
        if (wp != null) {
            history.add(wp);
        }
    }
}
