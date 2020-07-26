> 정확하지 않은 정보가 있을 수 있습니다.

# 객체지향

1. 코드 재사용
2. 유지보수 용이
3. 신뢰성 높은 프로그래밍

## 클래스와 객체

클래스란 객체를 정의해놓은 일종의 설계도다.
![](https://images.velog.io/images/cocodori/post/1987698a-1367-4dab-9ead-16bb19248c89/2.png)


> 도대체 클래스를 왜 만드는데?

클래스는 일종의 부품이 아닐까? 이를테면 거대한 우주선을 만든다고 하자.

수만가지의 부품이 필요하다. 그러나 우리는 그 부품들을 모두 만들어서 쓸 필요가 없다.

이미 누군가 만들어놓은 부품을 그대로 가져와서 쓰는 것이 (합리적이랄 것도 없이) 상식적인 선택이다. 물론 필요한 부품은 직접 만들 수도 있다. 사용자 정의 타입처럼.

아무튼.

클래스로 객체를 만드는 과정을 클래스의 인스턴스화라고 한다.

만들어진 클래스를 우리는 객체(=인스턴스)라고 부른다.

### 객체의 구성요소

  속성property과 기능function이 있다.

property - member variable

function - method

### 참 쉽고 진부한 객체지향 예제

```java
package com.javaex.ch6;

public class TvProps {
    //객체 프로퍼티
    private boolean power;
    private int channel;

    public TvProps() {
        this.channel = 1;
        this.power = false;
    }

    void power() {
        this.power = !power;
    }

    void channelUp() {
        this.channel = ++channel;
    }

    void channelDown() {
        this.channel = --channel;
    }

    public int getChannel() {
        return channel;
    }

}

package com.javaex.ch6;

public class Tv {
    public static void main(String[] args) {
        TvProps tv = new TvProps();
        TvProps tv2 = new TvProps();

        tv.channelUp(); //2
        tv.channelUp(); //3
        tv.channelUp(); //4

        tv2.channelUp(); //2

        System.out.println("tv.channel : " + tv.getChannel());

        System.out.println("tv2.channel : " + tv2.getChannel());

        tv.channelDown();

        System.out.println("tv.channel : " + tv.getChannel());

        /* 참조하는 객체의 주소가 다르다. */
        System.out.println("==========before========");
        System.out.println("tv : " + tv);
        System.out.println("tv2: " + tv2);

        /*tv2에 tv를 주입한다.*/
        tv2 = tv;

        /* 참조하는 객체의 주소가 같다. */
        System.out.println("==========After========");
        System.out.println("tv : " + tv);
        System.out.println("tv2: " + tv2);
    }
}
```

참고:자바의 정석

### 클래스

**클래스는 데이터와 함수(java에서는 method)의 결합이다.**

프로그래밍 언어에서 데이터 처리 저장형태의 발전과정은 다음과 같다.

1. 변수

    태초에 하나의 데이터만을 저장해둘 수 있는 공간이 있었다.

2. 배열

    1에 만족하지 못하는 탐욕스런 인간이 같은 종류의 여러 데이터를

    하나의 집합처럼 다룰 수 있는 저장형태를 만들었다.

3. 구조체structure

    이건 나도 생소하다.  서로 관련된 여러 데이터를 종류에 관계없이 집합처럼 저장할 수 있는 공간이라고 한다.

4. 그리고 클래스가 있었다

    구조체에 함수를 저장할 수 있는 공간을 더한 것이 클래스다.

**사용자 정의 타입(user - defined type) 클래스**

위에서 말했듯이 필요한 부품이 마땅하지 않다면, 직접 만들어 쓰면 된다.

사용자 정의 타입을 조합(또는 이용)해서 또다른 사용자정의타입 클래스를 만들어낼 수도 있다.

![](https://images.velog.io/images/cocodori/post/0eb7baea-e7f7-4f84-8c6d-e260436a3848/f5bfed4fda2d59283e89031a0ae93245976164441e4f6173de5adf204d8cc208_v1.jpg)

쉽게 말하자면.

1. 아이언맨, 캡틴 아메리카, 블랙 펜서, 헐크, 토르 클래스를 정의한다.
2. 1에서 정의한 각각의 아이언맨, 캡틴, 블랙펜서, 헐크, 토르 인스턴스를 생성해서 어벤져스라는 새로운 클래스를 만들어낼 수 있다.

## 변수와 메서드

변수는 세 종류가 있다.

1. 클래스 변수Class Variable
2. Instance Variable(=멤버변수)
3. 지역변수Local Variable

지역 변수를 제외한 모든 변수는 인스턴스 변수다.

지역 변수는 해당 변수가 선언된 블럭 밖을 벗어날 수 없다.

인스턴스 변수 중에서 static이 붙은 변수가 클래스 변수다.

> **인스턴스 변수? 클래스 변수? 뭐가 다른데?**

- ***instance variable***

클래스 영역에 선언한다. 해당 클래스의 인스턴스를 생성할 때 메모리에 올라간다.

따라서 객체를 생성할 때마다 값이 초기화된다.

인스턴스를 생성하지 않고서는 iv를 다룰 수 없다.

- ***class variable***

인스턴스 변수 앞에 'static'이 붙었다면 클래스 변수다.

cv의 가장 큰 특징은 클래스가 메모리에 로딩될 때 생성된다는 것이다. 프로그램이 종료될 때까지 유지되고 public을 붙이면 전역 변수global variable의 성격을 가진다.

iv처럼 각각의 객체마다 저장공간이 따로 있지 않다. 메모리에 올라간 cv는 하나의 저장공간을 가진다. iv처럼 참조변수.변수명으로 쓰는 게 아니라 클래스이름.변수명으로 쓴다.

물론 iv와 같이 참조변수.변수명으로 쓸 수도 있지만 권장하지 않는다. 

여러 개의 객체를 생성해도 static변수의 값은 공유된다.

**그러므로 static변수의 값은 항상 공통된 값을 갖는다.**

보통 final static ~하면서 변하지 않고 어떤 객체에서도 같아야 할 때 사용했던 것 같다.

```java
class Ironman {
    static String tonyStark = "robertDowneyJr";
}

public class Avengers {
    public static void main(String[] args) {
        System.out.println("================BEFORE====================");
        System.out.println("Ironman.tonyStark : " + Ironman.tonyStark);

        Ironman.tonyStark = "James Gosling";

        System.out.println("================AFTER====================");
        System.out.println("Ironman.tonyStark : " + Ironman.tonyStark);

				System.out.println("------------------------------------------");

        System.out.println("iron1.tonyStark : " + iron1.tonyStark);
        System.out.println("iron2.tonyStark : " + iron2.tonyStark);

        iron1.tonyStark = "SAME";

        System.out.println("--------------------------------------------");
        System.out.println("iron1.tonyStark : " + iron1.tonyStark);
        System.out.println("iron2.tonyStark : " + iron2.tonyStark);
    }

}

/*
결과
================BEFORE====================
Ironman.tonyStark : robertDowneyJr
================AFTER====================
Ironman.tonyStark : James Gosling

------------------------------------------
iron1.tonyStark : James Gosling
iron2.tonyStark : James Gosling
--------------------------------------------
iron1.tonyStark : STATIC is shared.
iron2.tonyStark : STATIC is shared.

*/
```

### Method

메서드란, 어떤 작업을 수행하는 여러 코드를 하나로 묶은 것이다.

![](https://images.velog.io/images/cocodori/post/7372770f-1785-45ef-bac6-93411d6d36ae/1.png)

이런 형태라고 볼 수 있다. Input이나 Output이 있을 수도, 없을 수도 있다.

위의 그림에 빗대어 메서드를 하나 만들어본다면 이렇다.

```java
class ColorBall {

    String ballColor;

    /* 어떤 색의 공이든 노란색 공으로 바꾸는 메서드 */
    String ballColorChange(String ball) { //선언부 return type - method name(parameter type)
        ball = "YellowBall";
        return ball;
    }
}

public class MethodEx {
    public static void main(String[] args) {

        ColorBall ball = new ColorBall();

        String ball1 = ball.ballColor = "red ball";
        String ball2 = ball.ballColor = "blue ball";

        System.out.println("----------before------------");
        System.out.println("ball1 : " + ball1);
        System.out.println("ball2 : " + ball2);

        System.out.println("-----------after------------");
        System.out.println("ball1 : " + ball.ballColorChange(ball1));
        System.out.println("ball2 : " + ball.ballColorChange(ball2));

    }
}

/* 결과
----------before------------
ball1 : red ball
ball2 : blue ball
-----------after------------
ball1 : YellowBall
ball2 : YellowBall
*/
```

ColorBall타입의 변수를 매개변수로 받는 ballColorChange메서드다.

이 메서드는 파란색 볼을 넣든, 초록색 볼을 넣든 노란색 볼로 바꾸어 출력한다.

메서드를 사용하는 이유 세 가지

1. 높은 재사용성

    위에서 든 예시는 간단하지만, 이것이 아주 복잡한 작업이면서, 반복해야 하는 작업이라면,

    그러니까 볼을 만들고 페인트로 도색하고, 말리고, 다시 다른 색으로 덮어쓰는 복잡하고 귀찮은 작업이라면, 메서드 하나만 정의해놓으면 귀찮은 일을 반복할 필요 없이 재사용할 수 있다.

2. 1에서 이어지는 장점인데, 중복을 제거할 수 있다.
3. 프로그램의 구조화

    큰 규모의 프로그램을 만들 때, 작업단위로 메서드를 만든다면

    전체 흐름을 쉽게 파악할 수 있도록 단순하게 구조화할 수 있다.
  
  
  - **_ 자바의 정석 3판을 참고했습니다. 틀린 내용이 있을 수 있습니다._
**
# JVM 메모리 구조
JVM은 프로그램을 수행하는데 필요한 메모리를 할당 받는다. JVM은 이 메모리를 여러 영역으로 나누는데, 주요 영역 세 가지다.
![](https://images.velog.io/images/cocodori/post/0f69cb6e-55e2-422f-8ee0-115e1a922c2e/unnamed.jpg)
- Method area
	클래스가 사용될 때, JVM은 해당 클래스의 클래스 파일*.class를 읽고 클래스에 대한 정보를 이곳에 저장한다. 당연히 클래스 변수도 이곳에 저장된다.

- Call Stack 혹은 Execution Stack
메서드 작업에 필요한 메모리 공간을 제공한다. 메서드가 호출되면 콜스택에 메모리가 할당되고, 작업이 끝나면 반환된다.

- Heap
인스턴스가 생성되는 공간이다. 인스턴스 변수도 이곳에 생성된다.

![](https://images.velog.io/images/cocodori/post/caffb823-e0ad-425f-a4de-4eed07d3a808/%ED%98%B8%EC%B6%9C%EC%8B%9Ccallstack%EC%9D%98-%EB%B3%80%ED%99%94.jpg)
위에서 말한 호출스택Call Stack은 이런 식으로 동작한다.

# 클래스(static) 메서드와 인스턴스 메서드

- 클래스 메서드란, 클래스 변수와 유사하다. 인스턴스 메서드 앞에 static을 붙이면 클래스 메서드가 된다.

> static 메서드는 언제 만들까?

 메서드 내에서 인스턴스 변수를 사용한다면 인스턴스 메서드여야 한다.
 반면 메서드 내에서 인스턴스 변수나, 인스턴스 메서드를 사용하지 않는다면 static메서드로 정의할 필요가 있다.


1. 클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통으로 사용하는 것에 static을 붙인다.

2. static변수는 인스턴스 생성 없이 사용할 수 있다.

3. static메서드는 인스턴스 변수를 사용할 수 없다.
	클래스 메서드가 호출 되었을 때, 객체(인스턴스)가 존재하지 않을 수 있으므로.
    반대는 가능하다.
4. 메서드 내에서 인스턴스 변수를 사용하지 않는다면 satic을 붙이는 것을 고려.

# 오버로딩Overloading
## 오버로딩이란?
같은 이름을 가진 메서드가 있더라도 매개변수의 개수 또는 타입이 다르면 같은 이름을 사용해서 메서드를 정의할 수 있다.

## 오버로딩 조건
 - 메서드 이름이 같다.
 - 매개변수 또는 타입이 다르다.

반환타입이 다른 것은 오버로딩이 아니다.

오버로딩의 대표적인 예로 println메서드가 있다.

```
void println()
void println(boolean x)
void println(char x)
void println(char[] x)
void println(double x)
void println(Object x)
void println(String x)
...
```

println이 이렇게 오버로딩이 되어 있기 때문에 우리는 println메서드 안에 어떤 타입이든 넣어서 쓸 수 있다.

## 오버로딩의 장점
 모든 메서드의 이름이 다르다면, 10개의 println은 모두 다른 메서드를 가져야 한다. 그러니까 char를 출력할 때는 printchar boolean을 출력할 땐 printbool...이런 식으로. 이름을 짓기도 어렵고 사용하는 쪽에서도 구분하기가 어렵다.
 오버로딩을 사용하면 기억하기도 쉽고 오류 가능성을 줄일 수도 있다. 또한 메서드 이름만 보고 이름이 같으니 같은 기능을 할 것이라는 사실을 짐작할 수 있다.
 
## 가변인자varargs와 오버로딩
가변인자로 동적으로 매개변수의 개수를 지정할 수 있다.
1. method(String str1, String str2, String str3)을
2. method(String... str)처럼 쓸 수 있다는 말이다.

method("a", "b")
method("a")
method(new String[]{"A", "B"})

모두 가능하다.
가변인자는 내부적으로 배열을 이용하기 때문에 성능이 떨어지는 단점이 있다. 따라서 꼭 필요한 경우에만 사용하는 게 좋다.

그리고
가변인자는 오버로딩할 수 없다. 

1번 메서드를 2번 메서드로 오버로딩했을 경우,
컴파일 시 두 메서드를 구분할 수 없어서 에러가 발생한다.

# 생성자Constructor
> 생성자는 인스턴스를 생성할 때 호출하며, 인스턴스 변수들을 초기화 하거나, 생성 시에 실행해야 할 작업을 위해 사용한다.

1. 이름은 클래스의 이름과 같고
2. 리턴값이 없다.

class Movie{}의 기본 생성자를 만든다면
public Moive() {}가 될 것이다.

모든 클래스에는 반드시 하나 이상의 생성자가 있어야 한다.
하나도 없을 때는 컴파일러가 자동으로 기본 생성자를 만들지만, 하나라도 생성자가 있는 경우에 컴파일러는 아무 일도 하지 않는다.

## 매개변수를 가진 생성자
매개변수 가진 생성자를 만들어놓으면, 해당 클래스의 객체를 생성할 때 원하는 값으로 초기화 할 수 있다. 이런 식으로.
```
class Ironman{
    boolean power;
    int strength;

    Ironman(boolean power, int strength) {
        this.power = power;
        this.strength = strength;
    }

}

public class Avengers {
    public static void main(String[] args) {
        Ironman iron = new Ironman(true, 100);
        System.out.println(iron.power);	//true
        System.out.println(iron.strong); // 100
    }
}
```

## this()

생성자 내에서 다른 생성자를 호출할 때 this()를 사용한다.
반드시 첫째 줄에서 사용해야 한다는 제약이 있다.
```
Ironman(int armour) {
  // Ironman(); //이런 식으로 호출하면 에러가 발생한다.
  this(); //반드시 이렇게 호출해야 한다.
}
```
이유는, 생성자 내에 초기화 작업 중 다른 생성자를 호출하게 되면, 호출된 다른 생성자 내에서도 멤버변수의 값을 초기화하게 된다. 그러면 다른 생성자를 호출하기 전 초기화 작업과 충돌이 날 가능성이 있다.

```
class CarCompo {
	String color;
	String gearType;
	int door;
	
	CarCompo() { //기본 옵션
		this("white", "auto", 4);
	}
	
	CarCompo(String color) { //색상 선택, 나머지 기본 옵션
		this(color, "auto", 4);
	}
	
	CarCompo(String color, String gearType, int door) { //옵션 모두 선택 가능
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	public String toString() {
		return "color : " + this.color + ", gearType : " + this.gearType + ", door : " + this.door;
		
	}
	
}

public class Car {
	public static void main(String[] args) {
		CarCompo defaultCar = new CarCompo();
		CarCompo colorOptionCar = new CarCompo("Red");
		CarCompo fullOption = new CarCompo("black", "auto", 2);
		
		System.out.println("defaultCar     : " + defaultCar);
		System.out.println("colorOptionCar : " + colorOptionCar);
		System.out.println("fullOption     : " + fullOption);
	}

}
/*
	결과
defaultCar     : color : white, gearType : auto, door : 4
colorOptionCar : color : Red,   gearType : auto, door : 4
fullOption     : color : black, gearType : auto, door : 2
*/
```

## this
> 자기 자신을 가리키는 참조변수 this

매개변수의 이름과 인스턴스 변수의 이름이 같을 때, 구분하려고 쓴다.
color = color라고 하면 둘 다 지역 변수로 간주된다.
참고로 static변수에는 this가 없다.
생성자를 포함한 모든 인스턴스 메서드에 자신이 관련된 인스턴스를 가리키는 참조변수 this가 지역변수로 숨겨진 채로 존재한다.
아무튼 정리하자면
> this - 인스턴스 자신을 가리키는 참조변수. 인스턴스의 주소가 저장되어 있다.
this() - 생성자. 같은 클래스의 다른 생성자를 호출할 때 쓴다.

this와 this()는 동료가 아니다.



# 변수의 초기화

변수에 처음 값을 저장하는 것을 초기화Initialization라고 한다.
멤버변수는 초기화하지 않아도 자료형에 맞는 기본값으로 초기화가 된다.
그러나 지역변수는 반드시 사용하기 전에 초기화해야 한다.
![](https://images.velog.io/images/cocodori/post/a3ba8ef1-9a29-490b-8430-db7545f86fca/maxresdefault.jpg)
타입의 기본 값
출처 : https://www.youtube.com/watch?v=KQDYyX6EdNA

## 멤버변수 초기화 방법

### 명시적 초기화Explicit Initialization
변수를 선언과 동시에 초기화하는 것을 명시적 초기화라고 한다.
int door = 4;
이게 명시적 초기화다.
가장 간단하고 명료하다. 따라서 우선적으로 고려되어야 할 방법이다.

### 초기화 블럭Initialization block
- 클래스 초기화 블럭 
클래스 변수의 복잡한 초기화에 사용한다.

- 인스턴스 초기화 블럭
인스턴스 변수의 복잡한 초기화에 사용한다.

차이는 간단하다. 아무 이름도 없는 {}블럭이 인스턴스 초기화 블럭이다.
앞에 static을 붙여서 static{}으로 만들면 클래스 초기화 블럭이다.
**클래스 초기화 블럭은 클래스가 메모리에 로딩될 때 딱 한 번 실행된다.
반면 인스턴스 블럭은 인스턴스를 생성할 때마다 실행된다.**

인스턴스 초기화는 보통 생성자로 한다.
생성자가 여러 개 있을 때, 여러 개의 생성자에서 중복되는 부분을 인스턴스 초기화 블럭을 만들어서 쓴다.

> **중복을 제거하고 재사용성을 높이는 것이 객체지향프로그래밍이 추구하는 궁극적인 목표다.**


## 초기화 순서
```
class InitTest {
	/*명시적 초기화*/
	static int cv = 1;
    int iv = 1;
    
    static {	//클래스 초기화 블럭
    	cv = 2;
    }
    
    { //인스턴스 초기화 블럭
    	iv = 2; 
    }
    
    InitTest() {	//생성자
    	iv = 3;
    }
    
}
```
![](https://images.velog.io/images/cocodori/post/c58dd40b-a8cc-41c2-9732-450a65b38176/12503B50502FBC241C.jpg)
출처:자바의 정석 305p

1.cv가 메모리에 로딩. 기본 값인 0으로 초기화. (static int cv)
2.static int cv = 1; 명시적 초기화로 1이 저장된다.
3.그 다음 클래스 초기화 블럭이 실행되면서 cv의 값을 2로 초기화 한다.
4.InitTest클래스의 인스턴스가 생성되면서 iv가 heap에 로딩된다.
iv역시 int형 변수이므로 0으로 초기화
5.명시적 초기화에 의해 iv에 1이 저장.
6.인스턴스 초기화 블럭이 실행되면서 iv를 2로 초기화.
7.마지막으로 생성자가 실행되면서 iv를 3으로 초기화한다.

-----
# 상속Inheritance

기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것이다.

코드를 공통적으로 관리할 수 있기 때문에 유지보수 하기 쉽다.

```java
class Child extends Parent {
	//...
}
```
extends만으로 간단하게 상속 받을 수 있다.

상속해주는 클래스Parent를 조상 클래스, 상속을 받는 클래스Child를 자손 클래스라고 한다.

이 두 관계를 **상속관계**라고 부른다.
![](https://images.velog.io/images/cocodori/post/e8b6bb23-99c7-467b-b665-29295b04fd95/typesofinheritance.jpg)


출처 : [https://www.javatpoint.com/inheritance-in-java](https://www.javatpoint.com/inheritance-in-java)

조상클래스는 자손 클래스가 변경 되어도 영향을 받지 않지만,

조상클래스가 변경되면 자손 클래스는 영향을 받는다.

자손 클래스는 조상 클래스의 모든 멤버를 상속 받는다. 따라서 항상 조상 클래스보다 같거나 많은 멤버를 갖는다. 상속에 상속을 거듭한다면, 멤버는 점점 확장(extends)된다. 그래서 상속을 이용한다는 것은 즉 조상 클래스를 확장extends한다는 의미이기도 하다.

**자바는 단일상속만 가능하다. 두 개의 클래스를 동시에 extends할 수 없다.**

**필요하다면 인터페이스나 포함관계를 이용하면 된다.**

## 포함관계

한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것을 뜻한다.

```java
class ArcReactor{
	//...
}
class TonyStark{
	ArcReactor arc = new ArcReactor();
}

class Ironman() {
	TonyStark tony = new TonyStark();
}
```

위와 같이 단위별로 여러 개의 클래스를 포함해서 더 큰 클래스를 만들어낼 수 있다.

프로젝트 진행할 때 extends는 한 번도 사용하지 않았지만 포함관계는 수도 없이 많이 사용했다.

## Object

Object는 모든 클래스의 조상이다. 아무것도 상속받고 있지 않은 클래스도 결국 Object를 상속받고 있다. toString()이나 equals() 같은 메서드는 모두 Object의 메서드다.

# 오버라이딩Overriding

상속 받은 메서드의 내용을 변경하는 것을 **오버라이딩**이라고 한다.

```java
class CarCompo {
	String color;
	String gearType;
	int door;

	/*Object클래스의 toString()을 오버라이딩해서 사용*/
	@Override
	public String toString() {
		return "CarCompo [color=" + color + ", gearType=" + gearType + ", door=" + door + "]";
	}
}
```

이클립스 기준 alt + shift + s → Override/implements Methods를 누르면 쉽게 오버라이드 할 수 있다.

@Override 어노테이션은 혹여 오버라이딩을 잘못 했을 경우를 대비해 항상 붙이는 것이 좋다.

오버라이딩이 잘못되었다고 바로 빨간 줄을 그어주니까.

### 오버라이딩  조건

- 이름이 같아야 한다
- 매개변수가 같아야 한다
- 반환타입이 같아야 한다
- 접근 제어자를 좁은 범위로 변경할 수 없다.
- 원래 메서드보다 많은 예외를 선언할 수 없다.

**오버라이딩과 오버로딩은 이름만 비슷할 뿐 동료가 아니다.**

> 오버로딩 : 기존에 없는 새로운 메서드를 정의하는 것(new)

오버라이딩:상속 받은 메서드를 변경하는 것(modify)

## super

super는 일종의 this다. 상속받은 멤버와 자신의 멤버 이름이 같을 때 super를 붙여서 구분한다.

코드를 보면 이해가 쉽다.

```java
public class Super {
	public static void main(String[] args) {
		Child child = new Child();
		child.method();
	}
}

class Parent {
	int x = 10;
}

class Child extends Parent {
	int x=20;
	
	void method() {
		System.out.println("x : " + x);
		System.out.println("this.x : " + this.x); //자신(Child)을 가리키는 this.
		System.out.println("super.x : " + super.x);//부모(Parent)를 가리키는 super.
	}

/*
결과 : 
x : 20
this.x : 20
super.x : 10
*/
```

super는 toString()을 오버라이딩 할 때 super.toString() + 자손 클래스의 인스턴스 변수 출력

하는 식으로 써봤던 것 같다. 나중에는 lombok을 쓰니 거의 사용할 일이 없긴 했다.

## super()

조상 클래스의 생성자를 호출할 때 쓴다.

생성자 첫 줄에서 사용해야 한다.  이유는 자손클래스의 멤버가 조상클래스 멤버를 사용할 수도 있으므로, 조상클래스의 멤버를 미리 초기화 해두어야 하기 때문이다.

> Oject클래스를 제외한 모든 클래스의 생성자 첫 줄에 this() 또는 super()를 호출해야 한다. 그렇지 않으면 컴파일러가 자동으로 생성자 첫 줄에 삽입한다.

인스턴스를 생성할 때는 이 두가지를 고려해야 한다.

1. 어떤 클래스의 인스턴스를 생성할 것인가?
2. 해당 클래스의 어떤 생성자를 이용해서 만들 것인가?

```java
public class Point {
	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		System.out.println("p3.x : " + p3.x);
		System.out.println("p3.y : " + p3.y);
		System.out.println("p3.z : " + p3.z);
	}
}

class PointXY {
	int x = 10;
	int y = 20;
	
	PointXY(int x, int y) {
		//super(); == Object()
		this.x = x;
		this.y = y;
	}
}

class Point3D extends PointXY {
	int z = 30;
	
	Point3D() {
		this(100, 200, 300);	//Point3D(int x, int y, int z) 호출
	}
	
	Point3D(int x, int y, int z) {
		super(x, y); //	PointXY(int x, int y) 호출
		this.z = z;
	}
	
}

/*
결과 : 
p3.x : 100
p3.y : 200
p3.z : 300
*/
```

참고자료 : 자바의 정석

----

# 제어자Modifier
## Non-Access-Modifiers

접근 제어자가 아닌 제어자들로는
static, final, abstract, synchronized......등이 있다.

몇 가지만 소개한다.
### static
멤버변수, 메서드, 초기화 블럭 앞에 붙는다.
static이 변수에 붙으면 모든 인스턴스에서 공통으로 사용되는 클래스 변수가 된다.
메서드에 붙으면 인스턴스 생성없이 호출할 수 있는 static 메서드가 된다.

### final
클래스, 메서드, 멤버변수, 지역변수에 붙는다.
final이 붙으면 수정할 수 없는 메서드, 변수, 클래스가 된다.
즉,
final변수는 값을 변경할 수 없는 상수.
final method는 오버라이딩 불가.
final class는 extends 불가.

>final 변수라도
생성자를 이용한 초기화를 통해 각 인스턴스마다 다른 값을 가지게 할 수 있다.

### abstract
클래스, 메서드 앞에 붙는다.
클래스에 붙으면, 추상 메서드가 선언되어 있다는 것을 뜻한다.
메서드에 붙으면 선언부만 있고 구현부가 없는 추상 메서드라는 것을 뜻한다.

## 접근 제어자Access-Modifiers
 자바에는  public, protected, default, private 이렇게 4개의 접근 제어자가 있다.
 ![](https://images.velog.io/images/cocodori/post/3137b374-ad31-42e7-8aa0-e4402a6b275a/Access-Modifiers.webp)

이미지 출처 : https://www.softwaretestingmaterial.com/access-modifiers-in-java/
 
- public - 접근 제한 없음
- protected 같은 패키지 내, 그리고 다른 패키지의 자손(sub)클래스에서만 접근 가능
- default 같은 패키지 내에서만 접근 가능
- private 같은 클래스 내에서만 접근 가능

![](https://images.velog.io/images/cocodori/post/6552f24a-7748-48d9-801e-ef45b75549e4/Access-Modifiers-Tabular-Column.webp)

이미지 출처 : https://www.softwaretestingmaterial.com/access-modifiers-in-java/

## 캡슐화
왜 귀찮게 접근을 제어할까? 데이터를 보호하기 위해서다. 클래스 외부에서 데이터를 함부로 변경하지 못하도록 보호할 필요가 있다. 이것을 데이터 감추기Data Hiding이라고 한다. Data Hiding은 객체지향개념에서 캡슐화Encapsulation에 해당하는 내용이다.
 내부에서만 이용하고, 외부에는 불필요한 부분을 감추기 위해 멤버를 private으로 지정하는데, 이것 역시 캡슐화에 해당한다.
 만약 Time이라는 클래스를 이렇게 정의한다고 하자.
```java
class Time {
	
    int hour;
    int minute;
    int second;
}
```
이러면 누가 언제 어디서든 값을 바꿀 수 있기 때문에 위험하고, 또 시간으로 들어와야 하는 값에 25이나 33 같은 유효하지 않은 값을 넣을지도 모른다. 이 문제를 해결하기 위해서 이렇게 쓴다.

```java
public class Time {

    private int hour, minute, second;

    Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    /* SETTER */
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    /*GETTER*/
    public void setHour(int hour) {
        if(hour < 0 || hour > 23) return; //유효성 검사
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if(minute < 0 || minute > 59) return;
        this.minute = minute;
    }

    public void setSecond(int second) {
        if(second < 0 || second > 59) return;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}

public class TimeMain {
    public static void main(String[] args) {
        Time time = new Time(13, 47, 22);
        //time.hour = 22; 이제 이런식으로 수정하지 않는다.
        time.setHour(time.getHour()+1);
        System.out.println(time);
    }
}
```
이런 식으로 하면 Time클래스의 멤버를 직접 수정할 수 없다. setter를 거쳐야 하기 때문에 유효성 검사를 통해 유효하지 않은 값은 return할 수 있다.

### 생성자의 접근 제어자
일반적으로 생성자의 접근 제어자는 클래스의 접근 제어자와 일치하지만 다르게 지정할 수 있다.
private으로 지정하면 외부에서 생성자에 접근할 수 없다. 해당 클래스 내에 인스턴스를 return하는 static메서드를 선언해두면, private생성자여도 외부에서 인스턴스를 생성할 수 있다.
> 주의할 점은 private 생성자를 가진 클래스는 다른 클래스의 조상이 될 수 없다. 따라서 class 앞에 fianl을 명시적으로 붙이는 것이 좋다.

위에 말이 좀 어려웠는데 코드로 보면 쉽다.
```java
final class Singleton {
    private Singleton() {}

    public static Singleton getInstance() {
        return new Singleton();
    }
}

public class SingletonTest {
    public static void main(String[] args) {
       //Singleton singleton = new Singleton(); //ERROR
        Singleton singleton = Singleton.getInstance();
    }
}
```

- 참고자료 : 자바의 정석


-----

# 다형성?

![](https://images.velog.io/images/cocodori/post/5d32f4ec-74f9-4514-bd2b-445583685bd2/maxresdefault.jpg)

운전하는 법은 한 번만 배우면 어떤 자동차든 운전할 수 있다. 자동차 브랜드나 내부 구현에 따라 달라지지 않는다. 동일한 인터페이스를 가지고 있기 때문이다. 이게 다형성이다.

OOP에서 다형성이란 여러가지 형태를 가질 수 있는 능력. 말하자면 조상클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조할 수 있는 것이다.
```java
class Tv {
	
    boolean power;
    int channel;
    
    void power{ power = !power;}
	void channelUp() { ++channel;}
    void channelDown() { --channel;}
}

class CaptionTv extends Tv {
	String text;
    void caption() {}
}
```

CationTv의 인스턴스를 Tv caption = new CaptionTv() 이런 식으로 생성할 수도 있다.
다만 이럴 경우 CaptionTv가 가지고 있는 caption()는 사용할 수 없다.

## 참조변수 형변환

```java
class Car {
    String color;
    int door;

    void drive() {
        System.out.println("drive, brrr....");
    }

    void stop() {
        System.out.println("stop...");
    }
}

class FireEngine extends Car {
    void water() {
        System.out.println("water...");
    }
}
public class CastingTest {
    public static void main(String[] args) {
        Car car = null;
   		//FireEngine fire = (FireEngine)new Car(); //ERROR

        FireEngine fireEngine = new FireEngine();
        FireEngine fireEngine2 = new FireEngine();
        fireEngine.water();
        

        car = fireEngine;
        //car.warter //사용 불가
        car.stop();
        fireEngine2 = (FireEngine)car;
        fireEngine2.water();
    }
}
```
형변환은 참조변수 타입을 변환하는 것일 뿐, 인스턴스를 변환하는 것은 아니다. 참조변수는 단지 참조하는 인스턴스에서 사용할 수 있는 멤버의 범위(개수)를 조절한다.

자손 -> 조상으로 형변환은 가능하지만
조상 -> 자손으로 형변환은 불가능하다.
왜?
실제 인스턴스인 Car의 멤버의 개수보다 FireEngine이 사용할 수 있는 멤버 개수가 더 많기 때문이다.

# instanceof 연산자
참조변수가 참조하고 있는 인스턴스의 실제타입을 알아볼 때 쓴다. boolean타입으로 return하기 때문에 주로 조건문에서 유효성 검사할 때 사용한다.
 instanceof의 결과가 true라는 것은 참조변수가 검사한 타입으로 형변환이 가능하다는 뜻이다.

```java
class InstanceofTest{ 
	public static void main(String[] args) {
		MotorCyle motorCycle = new MotorCyle();
		
		if(motorCycle instanceof MotorCyle) {
			System.out.println("MotorCyle Instance");
		}
		if(motorCycle instanceof Cycle) {
			System.out.println("Cycle Instance");
		}
		if(motorCycle instanceof Object) {
			System.out.println("Object Instance");
		}			
	}
}
class Cycle {}
class MotorCyle extends Cycle{}

/* 결과
MotorCyle Instance
Cycle Instance
Object Instance
*/
```

MotorCycle클래스는 자기 자신인 MotorCycle타입이면서, 조상인 Cycle타입이면서, 그의 조상인 Object타입이기도하다.
이처럼 instanceof는 자신의 타입 뿐만 아니라 조상타입에도 true를 반환한다. 그러므로 MotorCycle타입은 Cycle타입으로도, Object타입으로도 형변환 할 수 있다.

# 참조변수가 참조하는 변수
 메서드의 경우 조상 클래스의 메서드를 자손 클래스에서 오버라이딩 했다면, 참조변수 타입에 상관없이 실제 인스턴스의 메서드(오버라이딩한 메서드)가 호출된다.
 하지만 멤벼변수의 경우 이름이 같을 경우 참조 변수에 따라 값이 달라진다.
 ```java
class Super {
	
    int x = 10;
}
class Sub extends {

	int x = 20;
	
}

class Main {
	public static void main(String[] args) {
		Super s = new Super();
        Sub sub = new Sub();
        
        System.out.println(s.x); // 10
        System.out.println(sub.x); //20
    }
}
```

# 매개변수의 다형성
매개변수로 조상타입의 참조변수를 설정하면, 모든 자손타입의 참조변수를 매개변수로 받을 수 있다.
바로 위 예제를 참고하여, add(Super x)라는 메서드가 있다고 하자. 그럼 Super를 상속받는 Sub도 매개변수로 받을 수 있다는 뜻이다.
```java
package com.javaex.ch7;
/*
* 가격과 포인트 점수를 정의해놓은 클래스
* 모든 상품이 가지고 있어야 할 것들을 정의한다.
* */
class Product {
    int price;
    int bonusPoint;

    /*
    * Product를 상속하는 클래스들은 조상클래스의 생성자super()를 호출할 때 인자로 가격을 입력해야 한다.
    * Product()는 입력받은 가격으로 보너스포인트를 연산해서 변수에 저장한다.
    * */
    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0); //가격의 10%를 적립한다.
    }
}

class Tv extends Product {
    Tv() { 
        /*조상클래스의 생성자를 호출할 때 가격을 입력*/
        super(100); //Tv는 100만원이다.
    }
    
    //toString 오버라이딩
    @Override
    public String toString() { return "Tv"; }
}

class Computer extends Product {
    Computer() {super(200);}

    @Override
    public String toString() {return "Computer";}
}

/*
* 구매자의 정보를 정의한 클래스
* */
class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    /*
    * 구매자Buyer가 상품Product를 구매하면 이 메서드를 호출한다.
    * Product Type이기 때문에 Product를 상속하는 모든 클래스를 매개변수로 받을 수 있다.(매개변수의 다형성)
    * 구매자가 가진 돈과 상품 가격을 비교(유효성검사) 후, 돈이 충분하다면
    * 1.가진 돈에서 상품 가격을 뺀다.
    * 2.보너스 점수를 계산한 다음, 구매자의 보너수점수 변수에 저장한다.
    * */
    void buy(Product product) {
        if(money < product.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        money -= product.price;
        bonusPoint += product.bonusPoint;
        System.out.println(product +"상품을 구매하셨습니다.");
    }
}

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();

        buyer.buy(new Tv());
        buyer.buy(new Computer());

        System.out.println("남은 잔액 "+buyer.money+"만원");
        System.out.println("현재 포인트는 "+buyer.bonusPoint+"점");
    }
}
```

# 다양한 타입의 객체를 배열로

같은 클래스를 상속 받는 자손 클래스들을 묶어서 객체 배열을 만들 수 있다.
그러니까 상속 받는 클래스만 같다면, 타입이 달라도 하나의 배열로 다룰 수 있다는 것이다. 위의 예제를 약간 수정해서 배열을 만들었다. 

```java
package com.javaex.ch7;

import java.util.Arrays;

/*
* 가격과 포인트 점수를 정의해놓은 클래스
* 모든 상품이 가지고 있어야 할 것들을 정의한다.
* */
class Product {
    int price;
    int bonusPoint;

    /*
    * Product를 상속하는 클래스들은 조상클래스의 생성자super()를 호출할 때 인자로 가격을 입력해야 한다.
    * Product()는 입력받은 가격으로 보너스포인트를 연산해서 변수에 저장한다.
    * */
    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0); //가격의 10%를 적립한다.
    }

    Product() {}
}

class Tv extends Product {
    Tv() { 
        /*조상클래스의 생성자를 호출할 때 가격을 입력*/
        super(100); //Tv는 100만원이다.
    }
    
    //toString 오버라이딩
    @Override
    public String toString() { return "Tv"; }
}

class Computer extends Product {
    Computer() {super(200);}

    @Override
    public String toString() {return "Computer";}
}

class Audio extends Product {
    Audio() {super(50);}
    @Override
    public String toString() {return "Audio";}
}

/*
* 구매자의 정보를 정의한 클래스
* */
class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    //구입한 제품을 저장하기 위한 배열
    Product[] item = new Product[10]; //10개를 담을 수 있는 장바구니
    int i = 0; //배열에 사용할 index
    /*
    * 구매자Buyer가 상품Product를 구매하면 이 메서드를 호출한다.
    * Product Type이기 때문에 Product를 상속하는 모든 클래스를 매개변수로 받을 수 있다.(매개변수의 다형성)
    * 구매자가 가진 돈과 상품 가격을 비교(유효성검사) 후, 돈이 충분하다면
    * 1.가진 돈에서 상품 가격을 뺀다.
    * 2.보너스 점수를 계산한 다음, 구매자의 보너수점수 변수에 저장한다.
    * */
    void buy(Product product) {
        if(money < product.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        money -= product.price;
        bonusPoint += product.bonusPoint;
        item[i++] = product;
        System.out.println(product +"상품을 구매하셨습니다.");
    }
    
    /*구매한 상품 정보를 보여주는 메서드*/
    void summary() {
        int sum = 0;    //총가격
        String itemList = "";   //상품 목록

        for(int i=0; i<item.length;i++) {
            if(item[i] == null) break;

            sum += item[i].price; //상품 가격을 더한다.
            itemList += item[i] +", ";  //상품명을 추가한다.
        }
        System.out.println("구매하신 상품 목록은 " +itemList+"입니다.");
        System.out.println("구매하신 상품 총액은 " +sum+"입니다.");
    }
}

public class PolyArgumentTest {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();

        buyer.buy(new Tv());
        buyer.buy(new Computer());
        buyer.buy(new Audio());

        buyer.summary();

        System.out.println("남은 잔액 "+buyer.money+"만원");
        System.out.println("현재 포인트는 "+buyer.bonusPoint+"점");

    }
}
```





