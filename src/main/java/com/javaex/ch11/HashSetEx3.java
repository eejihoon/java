package com.javaex.ch11;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx3 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add(new Person("coco", 20));
        set.add(new Person("coco", 20));

        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            Person person = (Person)obj;
            return name.equals(person.name) && age == person.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }
}
