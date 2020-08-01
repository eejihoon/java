package com.javaex.generics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FruitBoxEx4 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();

        appleBox.add(new Apple("Green Apple", 300));
        appleBox.add(new Apple("Green Apple", 100));
        appleBox.add(new Apple("Green Apple", 200));

        grapeBox.add(new Grape("Pupple Grape", 400));
        grapeBox.add(new Grape("Pupple Grape", 200));
        grapeBox.add(new Grape("Pupple Grape", 300));

        System.out.println("===========정렬 전===========");
        System.out.println("appleBox : " + appleBox);
        System.out.println("grapeBox : " + grapeBox);
        System.out.println();

        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());

        System.out.println("===========정렬 후===========");
        System.out.println("appleBox : " + appleBox);
        System.out.println("grapeBox : " + grapeBox);
    }
}

class Fruit {
    String name;
    int weight;

    public Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "("+weight+")";
    }
}   //end - Fruit

class Apple extends Fruit {
    public Apple(String name, int weight) {
        super(name, weight);
    }
}

class Grape extends Fruit {
    Grape(String name, int weight) {
        super(name, weight);
    }
}

class FruitComp implements Comparator<Fruit> {  //내림차순

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o2.weight - o1.weight;
    }
}

class AppleComp implements Comparator<Apple> {

    @Override
    public int compare(Apple o1, Apple o2) {
        return o2.weight - o1.weight;
    }
}

class GrapeComp implements Comparator<Grape> {
    @Override
    public int compare(Grape o1, Grape o2) {
        return o2.weight - o1.weight;
    }
}

class FruitBox<T extends Fruit> extends Box<T> { }

class Box<T> {
    List<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    List<T> getList() {
        return list;
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}