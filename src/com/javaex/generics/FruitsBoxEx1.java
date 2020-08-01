//package com.javaex.generics;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FruitsBoxEx1 {
//    public static void main(String[] args) {
//        //매개변수화된 타입으로, 어떤 타입이든 올 수 있다.
//        Box<Fruit> fruitBox = new Box<>();  // == new Box<Fruit>();
//        Box<Apple> appleBox = new Box<>();
//        Box<Toy> toyBox = new Box<>();
//        /*
//        *Box<Fruit> box = new Box<Apple>(); 은 매개변수화된 타입이 다르므로 에러가 발생한다.
//        *반드시 참조 변수와 생성자의 매개변수화된 타입이 일치해야만 한다.
//        *다형성은
//        * Box<Apple> = new FruitBox<Apple>();
//        * 이렇게 사용할 수 있다.
//        * */
//
//        //void T add(T item) -> void add(Fruit item)
//        fruitBox.add(new Fruit());
//        fruitBox.add(new Grape());
//        fruitBox.add(new Apple());
//
//        appleBox.add(new Apple());
////        appleBox.add(new Graple());   //사과 박스엔 사과만 담을 수 있다.
//
//        toyBox.add(new Toy());
//
//        System.out.println("fruitBox : " + fruitBox);
//        System.out.println("appleBox : " + appleBox);
//        System.out.println("toyBox : " + toyBox);
//    }
//}
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
