# 람다식(LamdaExpression)
람다식은 익명 클래스와 동등한 기능을 하는 식(Expression)이다. 익명 클래스로 거추장스럽게 정의했던 것을 벗어나 간결한 식만으로 익명 클래스를 구현할 수 있다. 
- 익명 클래스
```java
new Object() {
    public void print(String msg) {
        System.out.println(msg);
    }
}
```
- 람다식
```java
msg -> System.out.println(msg);
```
위 코드는 람다를 보여주기 위한 간단한 예시일 뿐, 실제로 저 print()를 호출할 수는 없다. 요점은 람다식을 이용하면 훨씬 간결해진다는 것이다.
람다식을 사용하기 위해서는 람다식과 동등한 추상메서드가 선언된 인터페이스가 필요하다. 여기서 '동등하다'는 것은 추상메서드와 람다식의 매개변수와 반환타입이 일치한다는 뜻이다. 돈을 넣으면 커피가 나오는 커피 자판기 예제를 만들어봤다.
```java
@FunctionalInterface
public interface CoffeeMachine {
    public abstract String getCoffee(int coin);
}
```
위 인터페이스를 익명클래스와 람다식, 두 가지 방식으로 구현해봤다.
- 익명 클래스를 이용하는 방식
```java
CoffeeMachine machine = new CoffeeMachine() {
            @Override
            public String getCoffee(int coin) {
                return coin+"원 커피";
            }
        };
```
- 람다식을 이용하는 방식
```java
        CoffeeMachine lambdaMachine = coin -> coin+"원 커피";
```
여기서 익명객체와 람다식이 하는 일은 같다. 매개변수와 반환타입만 같다면 람다식이 익명객체를 대체할 수 있다.

하나의 추상메서드에 하나의 람다식. 1:1매칭. 자바에서는 람다식을 이렇게 다루기로 결정했다. 람다를 위한 단 하나의 추상메서드가 선언된 인터페이스를 **"함수형 인터페이스(Functional Interface)"**라고 부른다. 이 인터페이스는 당연히 매개변수나 반환타입으로 사용할 수 있다.

참고로 함수형 인터페이스로 람다식을 참조한다고 해서, 실제로 람다식이 그 인터페이스 타입인 것은 아니다. 람다식은 컴파일러가 정한 임의의 타입이다. 따라서 형변환이 필요하지만 생략할 수 있도록 설계되었을 뿐이다.