//package com.javaex.generics;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FruitsBoxEx2 {
//    public static void main(String[] args) {
//        FruitBox<Fruit> fruitBox = new FruitBox<>();
//        FruitBox<Apple> appleBox = new FruitBox<>();
//        FruitBox<Grape> grapeBox = new FruitBox<>();
//        ToyBox<Toy> toyBox = new ToyBox<>();
//
//        fruitBox.add(new Fruit());
//        fruitBox.add(new Apple());
//        fruitBox.add(new Grape());
//
//        appleBox.add(new Apple());
//
//        grapeBox.add(new Grape());
//
//        System.out.println("fruitBox - " + fruitBox);
//        System.out.println("appleBox - " + appleBox);
//        System.out.println("grapeBox - " + grapeBox);
//    }
//
//}
//
////Eatable을 구현하면서, Fruit를 상속하는 타입만 <T>로 받는다.
//class FruitBox<T extends Fruit & Eatable> extends Box<T> {}
////Funable을 구현한 타입만 <T>로 받는다.
//class ToyBox<T extends Funable> {}
//
//class Box<T> {
//    List<T> list = new ArrayList<>();
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
//
//    public String toString(){
//        return list.toString();
//    }
//}
//
//interface Eatable {}
//interface Funable {}
//
//class Fruit implements Eatable {
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
//class Toy implements Funable{
//    @Override
//    public String toString(){
//        return "Toy";
//    }
//}
//
