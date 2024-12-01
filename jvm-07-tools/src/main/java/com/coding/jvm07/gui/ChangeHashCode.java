package com.coding.jvm07.gui;

import java.util.HashSet;
import java.util.Objects;

public class ChangeHashCode {

    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1001, "BB");

        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);  // false
        System.out.println(set);

        set.add(new Person(1001, "CC"));
        set.add(new Person(1001, "DD"));
        System.out.println(set);
    }
}

class Person {
    int id;
    String name;

    public Person(int id, String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
