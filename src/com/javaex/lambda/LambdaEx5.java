//package com.javaex.lambda;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.function.Supplier;
//
//public class LambdaEx5 {
//    public static void main(String[] args) {
//        /*Suplier<T>는 매개변수는 없고 반환값만 있는 함수형 인터페이스다.
//        추상메서드 T get()가 1 ~ 100 사이 임의의 수를 리턴하도록 구현한다.*/
//        Supplier<Integer> supplier = () -> (int)(Math.random()*100) + 1;
//
//        /*Consumer<T>는 매개변수만 있고 반환값이 없는 함수형 인터페이스다.
//        * void accept(T t)를 입력 받은 매개변수를 출력하도록 구현하였다.
//        * */
//        Consumer<Integer> consumer = i -> System.out.print(i + ",");
//
//        /*
//        * Predicate<T>는 하나의 매개변수를 입력 받고, boolean을 return하는 함수형 인터페이스다.
//        * boolean test(T t)를 입력 받은 t가 2의 배수(i%2==0)라면 true 아니라면 false를 출력하도록 구현하였다.
//        * */
//        Predicate<Integer> predicate = i -> i%2==0;
//
//        /*
//        * Function<T,R>은 하나의 매개변수T를 받아 하나의 결과R를 출력한다.
//        * R apply(T t)를 입력 받은 t의 일의 자리를 없애도록 구현하였다.
//        * */
//        Function<Integer, Integer> function = i -> i/10*10; //i의 일의 자리를 없앤다.
//
//        List<Integer> list = new ArrayList<>();
//
//        //list에 10개의 난수를 저장한다.
//        makeRandomList(supplier, list);
//        //확인
//        System.out.println(list);
//
//        //list에 저장된 값 중에, 2의 배수인 것만 출력한다
//        printEvenNum(predicate, consumer, list);
//
//        //list에 저장된 값들의 일의 자리를 없애서 List를 return하는 메서드
//        List<Integer> newList = doSomething(function, list);
//        System.out.println(newList);
//
//    }
//
//    static <T> List<T> doSomething(Function<T,T> f, List<T> list) {
//        List<T> newList = new ArrayList<>();
//
//        /*list에 저장된 값을 i에 대입한다.
//        * i에 대입된 값에서 일의 자리를 없애고f.apply(i) newList에 저장한다.
//        * */
//        for (T i : list) { newList.add(f.apply(i)); }
//
//        //list의 값들을 일의 자리만 없앤 채로 return
//        return newList;
//    }
//
//
//    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
//        System.out.print("[");
//
//        /*
//        * 입력 list의 값을 하나씩 i에 대입한다.
//        * 그 중에 2의 배수인 것만 Consumer<T> c에 담는다.
//        * accept()는 매개변수 인자로 받은 i를 출력한다.
//        * */
//        for (T i : list ) {
//            if (p.test(i)) {
//                c.accept(i);
//            }
//        }
//        System.out.println("]");
//    }
//
//    //입력받은 list에 난수 열 개를 저장한다.
//    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
//        for (int i=0; i<10; i++) {
//            /*
//            * 반복문을 돌면서
//            * s.get()을 호출할 때마다
//            * 1 ~ 100 사이 임의의 수를 출력한다.
//            * */
//            list.add(s.get());
//        }
//    }
//}
