//package com.javaex.generics;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FruitsBoxEx3 {
//    public static void main(String[] args) {
//        FruitBox<Fruit> fruitBox = new FruitBox<>();
//        FruitBox<Apple> appleBox = new FruitBox<>();
//
//        fruitBox.add(new Apple());
//        fruitBox.add(new Grape());
//
//        appleBox.add(new Apple());
//
//        System.out.println(Juicer.makeJuice(fruitBox));
//        System.out.println(Juicer.makeJuice(appleBox));
//    }
//
//}
//
//class Juice {
//    String name;
//
//    public Juice(String name) {
//        this.name = name + "Juice";
//    }
//
//    @Override
//    public String toString() {
//        return this.name;
//    }
//}
//
//class Juicer {
//    static Juice makeJuice(FruitBox<? extends Fruit> box) {
//        String tmp = "";
//
//        for(Fruit fruit: box.getList()) {
//            tmp += fruit + " ";
//        }
//
//        return new Juice(tmp);
//    }
//}
//
//class FruitBox<T extends Fruit> extends Box<T> {}
//
//class Box<T> {
//    List<T> list = new ArrayList<>();
//
//    List<T> getList() {
//        return list;
//    }
//
//    void add(T item) {
//        list.add(item);
//    }
//
//    T getItem(int i) {
//        return list.get(i);
//    }
//
//    int size() {
//        return list.size();
//    }
//    @Override
//    public String toString(){
//        return list.toString();
//    }
//}
//
//class Fruit {
//    @Override
//    public String toString(){
//        return "Fruit";
//    }
//}
//
//class Apple extends Fruit {
//    @Override
//    public String toString(){
//        return "Apple";
//    }
//}
//
//class Grape extends Fruit {
//    @Override
//    public String toString(){
//        return "Grape";
//    }
//}
//class Toy {
//    @Override
//    public String toString(){
//        return "Toy";
//    }
//}
