# 자료구조와 알고리즘 
> 자료구조 알고리즘을 공부하면서 정리한 내용은 [자료구조](https://github.com/cocodori/java/tree/master/src/main/java/com/datastructure) , [알고리즘](https://github.com/cocodori/java/tree/master/알고리즘)에 있습니다.
> [블로그](https://coco-log.tistory.com/)
><br>앨런 B.다우니의 [Thinking Data Structures](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=148016214)를 참고하였습니다.

<br>


```java

    /**
     *  배열 array와 start값을 매개변수로 받는다.
     *  array[]의 start번째 인덱스부터 시작하여 마지막 인덱스까지 반복하면서
     *  가장 작은 값이 저장된 인덱스를 찾는다. 
     */
    public static int indexLowest(int[] array, int start) {
        /**
         *  가장 작은 값을 가진 인덱스를 저장할 변수
         *  일단 start번째 인덱스가 가장 작은 값을 가진 인덱스라고 가정한다.
         */
        int lowIndex = start;
        
        /**
         *  start번째 인덱스부터 배열의 끝까지 반복
         *  두 인덱스를 비교하고, 더 작은 값을 가지고 있는 인덱스를
         *  lowIndex에 저장한다.
         */
        for (int i = start; i<array.length;i++){
            if (array[i] < array[lowIndex]) {
                lowIndex = i;
            }
        } //for

        //가장 작은 값을 가진 인덱스를 리턴
        return lowIndex;
    } //indexLowest() 
```


[더보기](https://github.com/cocodori/java/tree/master/알고리즘)



# Java 

> 자바를 공부하면서 정리한 내용입니다.  <br>
>자세한 내용은 [블로그](https://velog.io/@cocodori/series/Java) 또는 [자바정리](https://github.com/cocodori/java/tree/master/자바정리) <br>
>참고 서적 : 📚 [자바의 정석](http://www.yes24.com/Product/Goods/24259565) 

<br>

# 자바란?

 썬 마이크로 시스템즈Sun Microsystems에서 개발하여 1996년 1월에 발표된 객체지향 프로그래밍 언어

![](https://images.velog.io/images/cocodori/post/08ff51a5-8a03-4c82-9408-227c58278785/james.jpg)

이 분이 자바를 만든 제임스 고슬링James Arthur Gosling이다

특징

1. JVM(Java Virtual Machine)을 이용하기 때문에 운영체제에 독립적
2. 객체지향언어(순수하지는 않은 듯)
3. 자동으로 메모리를 관리하는 Garbage Collection

[더보기](https://github.com/cocodori/java/blob/master/자바정리)