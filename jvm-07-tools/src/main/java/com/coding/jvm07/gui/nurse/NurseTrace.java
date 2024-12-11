package com.coding.jvm07.gui.nurse;

import java.util.ArrayList;
import java.util.List;

/**
 * 护士给园区的工作人员注射疫苗
 * <p>
 * VM options：-XX:+HeapDumpBeforeFullGC -XX:HeapDumpPath=/Users/wenqiu/Misc/nurse.hprof
 */
public class NurseTrace {
    static List<People> peopleList = new ArrayList<>();

    /**
     * 创建100个需要打疫苗的人员
     */
    static Integer peopleNum = 100;

    public static void createInjectPeople() {
        for (int i = 0; i < peopleNum; i++) {
            People people = new People();
            people.setAddress("beijingshi" + Integer.toString(i) + "号");
            people.setNum(Integer.toString(i));
            peopleList.add(people);
        }
    }

    public static void main(String[] args) {
        // 创建了100个需要打疫苗的人员
        createInjectPeople();
        // 创建3个护士
        Nurse nurse3 = new Nurse(3, "ZhangSan");
        Nurse nurse5 = new Nurse(5, "LiSi");
        Nurse nurse7 = new Nurse(7, "WangWu");
        for (int i = 0; i < peopleList.size(); i++) {
            if (i % nurse3.getId() == 0) {
                nurse3.inject(peopleList.get(i));
            }
            if (i % nurse5.getId() == 0) {
                nurse5.inject(peopleList.get(i));
            }
            if (i % nurse7.getId() == 0) {
                nurse7.inject(peopleList.get(i));
            }
        }
        peopleList.clear();
        System.gc();
    }
}
