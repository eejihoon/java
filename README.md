> [블로그](velog.io/@cocodori)에 올린 글을 옮겨둔 것입니다. 정확하지 않은 정보가 있을 수 있습니다.

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
----
![](https://images.velog.io/images/cocodori/post/4956a207-a903-4e82-b746-6f9282804109/interface%20VS%20abstract.png)

이미지 출처 : https://learn-tech-tips.blogspot.com/2016/07/object-oriented-programming-abstract-class-vs-interface.html


# 추상 클래스abstract class

> 추상 클래스란?
미완성 클래스 즉, 완성되지 않은 abstract 메서드를 포함하고 있는 클래스라는 뜻이다.

## 추상 메서드abstract method

메서드는 선언부와 구현부로 나눈다. 선언부만 있고 구현부는 작성하지 않은 메서드를 추상 메서드라고 부른다.

추상 클래스를 상속받는 자손 클래스는 부모 클래스가 가진 모든 추상 메서드를 구현해야만 한다.

추상 클래스는 해당 클래스를 상속 받을 자손들이 사용하는 공통 부분을 뽑아내서 정의한다.

추상 클래스를 사용하는 이유는 해당 클래스를 상속하는 자손들에게 이 메서드들은 반드시 구현해야 한다고 강제하기 위해서다.

# 인터페이스Interface

인터페이스는 일종의 추상클래스지만, 추상클래스보다 추상화 정도가 높다.

인터페이스에 선언 가능한 것

- 추상 메서드
- 상수
- static 메서드
- default 메서드

위 네 개를 제외한 다른 것은 선언할 수 없다.

작성 규칙

1. 선언 시 class대신 interface라는 키워드를 사용한다.
2. 멤버 변수에 public static final이 붙는다.
3. 메서드 앞에 public abstract가 붙는다.
4. 제어자가 항상 같기 때문에 2,3번에 붙는 제어자를 생략할 수 있다.

인터페이스는 해당 인터페이스를 구현implements하는 클래스에게 어떤 식으로 메서드를 만들어야 하는지 도움을 주기 위해 작성한다.

특징

- 다중 상속 가능
대신 인터페이스로부터만 상속 받을 수 있다.
어차피 잘 안 쓴다.
- extends 대신 implements 사용
- 이름이 ~able로 끝나는 경우가 많음
어떤 기능을 하는데 필요한 메서드를 제공한다는 의미를 강조하기 위해 able로 끝맺는 경우가 많다.

## 인터페이스의 다형성

인터페이스를 구현implements하는 것도 일종의 상속이기 때문에 extends하는 것과 마찬가지로 사용할 수 있다.

- 인터페이스 타입의 참조변수로, 해당 인터페이스를 구현한 클래스의 인스턴스를 참조할 수 있다.

```
//List는 interface고 ArrayList는 이를 구현한 클래스다.
List<String> list = new ArrayList<>();

```

- 매개변수의 타입으로 인터페이스를 사용할 수 있다.

## 인터페이스의 장점

1. 개발시간 단축
선언부만 알면 된다.
어떻게 구현되었는 지 알 필요 없고, 어떤 기능을 하는지 알고 있으면 된다.
2. 표준화
협업할 때 인터페이스를 구현함으로써, 일관되고 정형화된 프로그래밍 가능.
3. 관계없는 클래스들을 관계 맺어줌
같은 인터페이스를 구현함으로써 클래스들은 서로 연결된다.
4. 독립적인 프로그래밍
인터페이스를 이용하면 한 클래스의 변경이 직접적으로 다른 클래스에 영향을 끼치지 않는다.

```
package com.javaex.ch7;
/*
* 인터페이스 예제
* 참고:W3school
* */
interface Aniaml {
    void animalSound(); //public abstract생략
    void sleep();
}

class Pig implements Aniaml {
    @Override
    public void animalSound() {
        //구현
        System.out.println("PIG SAY : GGOOL GGOOL");
    }
    @Override
    public void sleep() {
        System.out.println("Zzz");
    }
}

class Panda implements Aniaml {
    @Override
    public void animalSound() {
        System.out.println("Panda Sound : NYANG~");
    }
    @Override
    public void sleep() {
        System.out.println("CooooooCooooo.....");
    }
}

public class MainAnimal {
    public static void main(String[] args) {
        Pig pig = new Pig();
        Panda panda = new Panda();
        pig.animalSound();
        pig.sleep();
        panda.animalSound();
        panda.sleep();
    }
}

```

동물을 구현한다고 했을 때, 동물은 모두 소리를 내고 잠을 자지만, 내는 소리가 다르고, 잠을 자는 형태가 다르다. 그럴 떄, 인터페이스에 선언해놓고 각각의 동물 클래스에서 구현하게 하면, 프로그램은 정형화 되고, 유지보수하기 쉬운 형태가 된다.
또한 Pig클래스의 animalSound()가 달라진다고해서 Panda클래스에 영향을 끼치지 않는다.

# 인터페이스의 이해

> 그래서 도대체 인터페이스가 뭔데?

인터페이스를 사용하는 쪽(User)와 제공하는 쪽(Provider)가 있다.
User는 Provider의 선언부만 알면 된다. 인터페이스는 구현부를 감싸고 있는 껍데기다.

![](https://images.velog.io/images/cocodori/post/f450410e-90b4-4704-b993-2e97af45f70e/interfaceImages.png)
출처:http://www.hitthebits.com/2012/11/what-are-interfaces.html

이런 거다. 우리는 스위치interface 뒤에서 무슨 일이 일어나는지 알 필요가 없다.

# default Method & static method
완성된 default메서드와 static메서드를 인터페이스 내에 정의할 수 있다.
해당 인터페이스를 구현하는 클래스는 default메서드를 오버라이딩해서 사용할 수 있다.
----

# 내부클래스의 종류
내부 클래스는 단순히 클래스 내에 선언된 클래스다.
- 내부 클래스의 장점
	1.내부 클래스에서 외브 클래스 멤버에 쉽게 접근 가능
    2.코드 복잡성을 줄인다(캡슐화)

![](https://images.velog.io/images/cocodori/post/a8f7a080-369e-44c4-bb22-5b19b8f43378/nested_classes.png)
위 다이어그램에서 보다시피 내부 클래스는 클래스의 멤버처럼 다룬다. 다른 점은 익명 클래스Anonymous class가 있다.

# 내부클래스의 제어자, 접근성

자바의 정석 예제에 간단히 주석을 달았습니다.

```javai
class Outer {
    class InstanceInner {
        int iv = 100;
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 300;
    }

    void myMethod() {
        class LocalInner {
            int iv = 400;
        }
    }
}

public class InnerEx4 {
    public static void main(String[] args) {
        /*
        * 인스턴스내부클래스의 인스턴스를 생성하려면
        * 외부클래스의 인스턴스가 먼저 필요하다.
        * */
        Outer outer = new Outer();
        Outer.InstanceInner instanceInner = outer.new InstanceInner();

        System.out.println("instanceInner.iv : " + instanceInner.iv);
        System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);

        /*static 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다.*/
        Outer.StaticInner staticInner = new Outer.StaticInner();
        System.out.println("staticInner.iv : " + staticInner.iv);
        System.out.println("staticInner.iv : " + staticInner);
    }
}
```

# 익명클래스anonymous class

익명클래스는 이름 없는 내부 클래스다. 이름이 없으므로 객체를 생성할 수 없고, 재사용할 수도 없다.

```java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Anonymous {
    public static void main(String[] args) {
        Button button = new Button("Start");
    }
}

class EventHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionEvent Occured!");
    }
}
```
이런 코드를

```java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Anonymous {
    public static void main(String[] args) {
        Button button = new Button("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!!!");
            }
        });
    }
}
```
익명클래스를 이용해서 이렇게 변경할 수  있다.

> **Collections Framework**는 다수의 데이터를 다루는 데 필요한 다양한 클래스를 제공한다.

# 핵심 인터페이스
----

![](https://images.velog.io/images/cocodori/post/422c167a-fd37-4cda-bddd-ee0dc6d245ea/collection.png)

상속계층도
이미지 출처 : http://dinfree.com/lecture/language/112_java_6.html

|interface|특징|구현 클래스|
|----|----|---|
|List|순서가 있는 데이터 집합. 중복 허용|ArrayList, LinkedList, Stack, Vector 등|
|Set|순서를 유지하지 않는 데이터 집합. 중복 없음.|HashSet, TreeSet|
|Map|key, value 쌍(pair)으로 이루어진 데이터 집합.<br>순서 유지 안 됨. key는 중복 안 됨.|HashMap, TreeMap, Hashtable, Properties

컬렉션 프레임워크의 모든 컬렉션 클래스들은 List, Set, Map중 하나를 구현하고 있다. 또한 구현한 인터페이스의 이름을 포함하고 있기 때문에 쉽게 구분할 수 있다.
예외로 Vector, Hashtable, Properties는 컬렉션 프레임워크 이전부터 있었기 때문에 명명규칙을 따르지 않는다.


# Collection Interface
----
Collection인터페이스는 컬렉션 클래스에 저장된 데이터를 읽고, 추가하고 삭제하는 기본적인 메서드를 정의하고 있다.

|method|설명|
|----|----|
|boolean add(Obejct o)<br>boolean addAll(Collection c)|지정된 객체Object 또는 Collection의 객체를 Collection에 추가한다.|
|void clear()|Collection의 모든 객체를 삭제한다.
|boolean contains(Object o)<br>boolean containsAll(Collection c)|지정된 Object 또는 Collection객체가 Collection에 포함되어 있는지 확인한다.|
|boolean equals(Object o)|동일한 Collection인지 확인한다.|
|int hashCode|Collection의 hash code를 반환한다.|
|boolean isEmpty()|Collection이 비어있는지 확인한다.|
|Iterator iterator()|Collection의 Iterator를 얻어서 반환한다.|
|boolean remove(Object o)|지정된 객체를 삭제한다.|
|boolean removeAll(Collection c)|지정한 Collection에 포함된 객체를 삭제한다.|
|int size()|Collection에 저장된 객체의 수를 반환한다.(=length)|
|Object[] toArray()|Collection에 저장된 객체를 객체배열Object[]로 반환한다.|
|Object[]toArray(Object[] a)|지정한 배열a에 Collection의 객체를 저장해서 반환한다.|

# List
---

**List인터페이스의 특징**
- 중복 허용
- 순서 유지

|method|설명|
|------|---|
|void add(int index, Object element)<br>boolean addAll(int index, Collection c)|지정한 index에 객체element 또는 컬렉션에 포함된 객체를 추가한다.|
|Object get(int intex)|지정한 index에 있는 객체 반환한다.|
|int indexOf(Object o)|지정한 객체의 위치를 순방향으로 찾아서 반환한다.|
|int lastIndexOf(Object o)|지정한 객체의 위치를 역방향으로 찾아서 반환한다.|
|ListIterator listIterator()<br>ListIterator listIterator(int index)|List객체에 접근할 수 있는 ListIterator를 반환한다.|
|Object remove(int index)|지정한 index에 있는 객체를 지우고, 삭제한 객체를 반환한다.|
|Object set(int index, Object element)|지정한 index에 객체element를 저장한다.|
|void sort(Comparator c)|지정한 비교자comparator로 List를 정렬한다.|
|List subList(int fromIndex, int toIndex)|지정한 범위from~to에 있는 객체를 반환한다.|

# Set
---
**특징**
- 중복 허용 하지 않음.
- 순서 유지 안 됨

구현 클래스로 HashSet, TreeSet이 있음. (위 계층도 참고)

# Map
---
key와 value를 하나로 묶어서 저장하는 컬렉션 클래스를 구현할 때 사용한다.
구현 클래스는 위 그림 참고
- key는 중복 X, value는 중복 O

|method|설명|
|------|---|
|void clear()|Map의 모든 객체 삭제한다.|
|boolean containsKey(Object key)|지정한 key와 일치하는 객체가 있는지 확인한다.|
|boolean containsValue(Object value)|지정한 value와 일치하는 객체가 있는지 확인한다.|
|Set entrySet()|Map에 저장된 key-value를 Map.Entry타입 객체로 저장한 Set으로 반환한다.|
|boolean equals(Object o)|동일한 Map인지 비교한다.|
|Object get(Object key)|지정한 key객체에 대응하는 value객체를 반환한다.|
|int hashCode()|해시코드를 반환한다.|
|Object put(Object key, Object value)|Map에 key-value를 연결mapping하여 저장한다.|
|void putAll(Map t)|지정한 Map의 모든 key-value쌍을 추가한다.|
|Object remove(Object key)|지정한 key와 일치하는 key-value를 삭제한다.|
|int size()|Map에 저장된 key-value쌍의 개수를 반환한다.|
|Set keySet()|Map에 저장된 모든 key객체를 반환한다.|
|Collection values()|Map에 저장된 모든 value객체를 반환한다.|

values()의 반환타입은 Collection.
KeySet()의 반환타입은 Set.

왜?

key는 중복을 허용하지 않으므로 Set으로 반환해도 문제가 없다.
하지만 value는 중복을 허용하기 때문에 Set으로 반환했을 경우 문제가 발생할 수 있다.
따라서 value는 Set이 아닌 Collection타입으로 반환한다.

# Map.Entry
---
Map인터페이스의 내부 인터페이스inner interface
Map인터페이스를 구현하는 클래스는 Map.Entry인터페이스도 함께 구현해야 한다.

|메서드|설명|
|---|---|
|boolean equals(Object o)|동일한 Entry인지 비교한다.|
|Object getKey()|Entry의 key객체를 반환한다.|
|Object getValue()|Entry의 value객체를 반환한다.|
|int hashCode()|Entry의 해시코드를 반환한다.|
|Object setValue(Object value)|Entry의 value객체를 지정한 객체로 바꾼다.|


> <cite>자바의 정석을 참고하여 작성한 글입니다.</cite>
>
----
# Collections Framework - 2.List


# ArrayList
ArrayList는 컬렉션 프레임워크에서 가장 많이 사용하는 클래스다. Object를 이용해 순차적으로 데이터를 저장한다. 저장 공간이 없으면 동적으로 크기가 늘어난다. 새로운 배열을 만들어서 기존의 배열을 복사해 다시 저장한다.
```java
public class ArrayList extends AbstractList
	implements List, RandomAccess, Cloneable, java.io.Serializable {
    	...
        transient Object[] elementData;	//Object배열
        ...
    }
```

ArrayList의 소스 일부다. elementData라는 이름의 Object[]를 멤버 변수로 선언해놨다. 따라서 ArrayList는 모든 타입의 객체를 담을 수 있다.

ArrayList의 메서드들

|method|설명|
|----|----|
|ArrayList()|크기가 10인 ArrayList를 생성|
|ArrayList(Collection c)|주어진 컬렉션이 저장된 ArrayList를 생성|
|ArrayList(int initialCapacity)|지정한 초기용량을 가지는 ArrayList 생성|
|boolean add(Object o)|객체를 추가. 성공하면 true|
|void add(int index, Object element)|지정한 index에 element 추가|
|boolean addAll(Collection c)|주어진 컬렉션의 모든 객체를 저장|
|boolean addAll(int index, Collecton c)|지정한 index부터 주어진 컬렉션의 모든 객체를 저장|
|void clear()|ArrayList를 완전히 비운다|
|Object clone()|ArrayList를 복제|
|boolean contains(Object o)|지정한 객체가 ArrayList에 포함 되어 있는지 확인|
|void ensureCapacity(int minCapacity)|ArrayList의 용량이 최소한 minCapacity가 되도록 한다.|
|Object get(int index)|지정한 index에 저장한 객체를 반환|
|int indexOf(Object o)|지정한 객체가 저장된 위치를 찾아 반환한다.|
|boolean isEmpty()|ArrayList가 비어있는지 확인한다.|
|Iterator iterator()|ArrayList의 Iterator객체를 반환|
|int lastIndexOf(Object o)|객체가 저장된 위치를 역방향으로 검색해서 반환|
|ListIterator listIterator()|ArrayList의 ListIterator를 반환|
|ListIterator listIterator(int index)|지정한 위치부터 시작하는 ListIterator반환|
|Object remove(int index)|지정한 위치에 있는 객체 제거|
|boolean remove(Object o)|지정한 객체 제거|
|boolean removeAll(Collectionc)|지정한 컬렉션에 저장된 것과 동일한 객체들을 ArrayList에서 제거|
|boolean retainAll(Collection c)|ArrayList에 저장된 객체 중, 주어진 컬렉션과 공통된 것들을 남기고 삭제|
|Ojbect set(int index, Object element)|주어진 객체를 지정한 위치에 저장|
|int size()|저장된 객체 개수 반환|
|void sort(Comparator c)|지정한 정렬기준으로 정렬|
|List subList(int fromIndex, int toIndex)|from~to사이 저장된 객체 반환|
|Object[] toArray()|ArrayList에 저장된 모든 객체를 객체 배열로 반환|
|Object[] toArray(Object[] a)|ArrayList에 저장된 모든 객체를 객체배열에 담아 반환|
|void trimToSize()|용량을 크기에 맞게 줄인다.(빈공간 없앤다.)|

다음은 Vector의 실행과정인데 ArrayList와 크게 다르지 않다.

```java
package com.javaex.ch11;

import java.util.Vector;

public class VectorEx1 {
    public static void main(String[] args) {
        Vector vector = new Vector(5);  //Capacity가 5인 Vector객체
        vector.add("1");
        vector.add("2");
        vector.add("3");
        print(vector);

        vector.trimToSize();    //빈공간 없앤다.
        System.out.println("============================AFTER trimToSize()");
        print(vector);

        vector.ensureCapacity(6);
        System.out.println("============================after ensureCapacity(6)");
        print(vector);

        vector.setSize(7);
        System.out.println("================================setSize(7)");
        print(vector);

        vector.clear();
        System.out.println("==================================clear()");
        print(vector);

    }

    static void print(Vector vector) {
        System.out.println("===============================================");
        System.out.println(vector);
        System.out.println("size : " + vector.size());
        System.out.println("capacity : " + vector.capacity());
    }

}

/*
결과 :
===============================================
[1, 2, 3]
size : 3
capacity : 5
============================AFTER trimToSize()
===============================================
[1, 2, 3]
size : 3
capacity : 3
============================after ensureCapacity(6)
===============================================
[1, 2, 3]
size : 3
capacity : 6
================================setSize(7)
===============================================
[1, 2, 3, null, null, null, null]
size : 7
capacity : 12
==================================clear()
===============================================
[]
size : 0
capacity : 12
*/
```

그림으로 진행 과정을 보면 이렇다.


1. new Vector(5)
문자열 1,2,3을 저장한 후 상태는 이렇다.
![](https://images.velog.io/images/cocodori/post/28fbdf56-71cc-477b-b274-74e2bbff305d/image.png)

2.vector.trimToSize()
배열은 크기를 변경할 수 없다. 따라서 새로운 배열을 생성해 변수 vector에 할당한다.
사용하지 않는 0x100은 가비지 컬렉터가 메모리에서 제거한다.
![](https://images.velog.io/images/cocodori/post/1099597b-e083-43f0-ae30-f2b19145b2c5/image.png)


3.vector.ensureCapacity(6)
	마찬가지로 새로운 객체를 생성해서 기존 내용0x200을 복사한. 그 다음 vector에 새로운 주소를 할당한다.
![](https://images.velog.io/images/cocodori/post/58f6db7b-4230-45b9-9134-7361bfc0fd8b/image.png)

4.vector.size(7)
capacity가 충분하지 않을 경우, 자동으로 기존의 크기보다 2배 큰 배열을 만들어서 복사한다.
0x300과 연결이 끊기고 0x400에 연결된다.
![](https://images.velog.io/images/cocodori/post/10eb9591-cd33-41c1-adf2-67064d0c596e/image.png)

5.vector.clean()
주소는 바뀌지 않고 모든 데이터를 지운다.

![](https://images.velog.io/images/cocodori/post/29203b5d-2f35-4525-ad67-f73cf55da8eb/image.png)

ArrayList나 Vector같은 배열 기반 자료구조는 데이터를 읽고 저장하는데 효율이 좋다. 그에 반해 용량을 늘려야 할 때는 새로운 배열을 생성하고, 기존의 배열을 복사하기 때문에 상당히 **효율이 떨어진다.** 애초에 데이터의 개수를 잘 고려해서 인스턴스를 생성하는 것이 좋다.

# LinkedList
배열은 가장 기본적인 형태의 자료구조다. 구조가 단순하고, 데이터를 읽어오는 시간access time이 가장 빠르다는 장점을 가지고 있다. 그러나 역시 단점도 있다.
- 크기를 변경할 수 없다.
위에서도 설명했다시피, 크기를 늘려야 할 때마다 새로 배열을 만들어서 기존의 데이터를 복사해야 하는 번거롭고 효율이 떨어지는 작업을 반복해야 한다.

- 순차적이지 않은 데이터 추가, 삭제에 많은 시간을 소요한다.
배열 중간에 데이터를 추가한다면, 빈자리를 만들기 위해 그 뒷자리에 오는 모든 요소를 복사해서 뒤로 한 칸씩 옮겨야 한다는 단점이 있다.

이 단점을 보완하기 위해 LinkedList라는 자료구조가 등장했다.
기존 배열은 데이터가 연속으로 존재하지만, LinkedList는 그렇지 않다. 연속적이지 않은 데이터를 연결Link하는 형태로 구성되어 있다.

![](https://images.velog.io/images/cocodori/post/3b786d79-3e93-4850-951a-fea4810d1584/difference-between-arrays-and-linked-list.png)

이미지 출처 : https://www.faceprep.in/data-structures/linked-list-vs-array/

![](https://images.velog.io/images/cocodori/post/5e5ffdb3-a7f5-44ae-b36f-769b1452eb61/rVCdE.png)
LinkedList에서 중간에 저장된 데이터를 삭제할 경우, 자리 이동 없이 next node에 대한 참조만 바뀐다. 따라서 배열에 비해 속도가 빠르다.
다만, LinkedList는 단방향이기 때문에 다음 요소next node에 접근하는 것은 빠르지만, 이전 요소Prev node로 접근하는 것은 어렵다. 이 점을 보완하기 위해 이중 연결 리스트doubly linked list가 나왔다. 

![](https://images.velog.io/images/cocodori/post/702f19d0-77d4-4fcb-b07d-6fd94d47e003/VJdku.gif)

 위 그림은 더블 링크드 리스트에서 접근성을 향상시킨 더블 써큘러 링크드 리스트doubly circular linked list다. 마지막 다음이 첫 번째 요소가 되고, 첫 번째 요소 이전이 마지막 요소가 되는 부분 말고는 더블 링크드 리스트와 다르지 않다. LinkedList의 낮은 접근성을 높이기 위해 이렇게 설계되었다.
 
 **LinkedList의 메서드**


|method|설명|
|----|----|
|LinkedList()|(생성자)|객체 생성|
|LinkedList(Collection c)|주어진 컬렉션을 포함하는 객체 생성|
|boolean add(Object o)|지정한 객체를 LinkedList에 추가.|
|boolean addAll(Collection c)|주어진 컬렉션에 포함된 모든 요소를 추가|
|boolean addAll(int index, Collection c)|지정한 index부터 주어진 컬렉션에 포함된 모든 요소 추가|
|void clear()|모든 요소 삭제|
|boolean contains(Object o)|지정한 객체를 포함하고 있다면 true|
|boolean containsAll(Collecton c)|지정한 컬렉션의 모든 요소를 포함하고 있다면 true|
|Object get(int index)|지정한 index의 객체를 반환|
|int indexOf(Object o)|지정한 객체가 저장된 위치를 반환|
|boolean isEmpty()|LinkedList가 비었다면 true|
|Iterator iterator()|Iterator객체 반환|
|int lastIndexOf(Object o)|지정한 객체의 index를 반환한다.|
|Object remove(int index)|지정한 index의 객체를 제거|
|boolean remove(int index)|지정한 index의 객체를 제거|
|Object set(int index, Object element)|지정한 index의 객체를 주어진 객체elemetn로 바꾼다.|
|int size()|객체의 개수를 반환|
|List subList(int fromIndex, int toIndex)|from~to사이에 있는 객체를 반환|
|Object[] toArray()|저장된 객체를 배열로 반환|
|Object[] toArray(Object[] a)|저장된 객체를 주어진 배열a에 저장하여 반환|
|Object element()|첫 번째 요소를 반환|
|Object peek()|첫 번째 요소를 반환|
|boolean offer(Object o)|지정한 객체o를 LinkedList에 추가|
|Object poll()|첫 번째 요소를 반환. 반환한 요소는 삭제된다.|
|Object remove()|첫 번째 요소를 삭제|
|void addFirst(Object o)|맨 앞자리에 객체o를 추가|
|void addLast(Object o)|맨 끝자리에 객체 추가|
|Iterator descendingIterator()|역순으로 조회하기 위한 DesendingIterator반환|
|Object getFirst()|첫 번째 요소를 반환|
|Object getList()|마지막 요소를 반환|
|boolean offerFirst(Object o)| 맨 앞자리에 객체o를 추가|
|boolean offerLast(Object o)|맨 뒷자리에 객체o를 추가|
|Object peekFirst()|첫 번째 요소 반환|
|Object peekLast()|마지막 요소 반환|
|Object pollFirst()|첫 번째 요소 반환하면서 삭제|
|Object pollLast()|마지막 요소 반환하면서 삭제|
|Object pop()|첫 번째 요소를 삭제(==removeFirst())|
|void push(Object o)|맨 앞자리에 객체o를 추가(addFirst()와 동일)|
|Object removeFirst()|첫 번째 요소 제거|
|Object removeLast()|마지막 요소 제거|
|boolean removeFirstOccurrence(Object o)|첫번째로 일치하는 객체 제거|
|boolean removeLastOccurrence(Object o)|마지막으로 일치하는 객체 제거|


 
## ArrayList vs LinkedList
1. 순차적으로 추가/삭제 하는 경우 ArrayList가 빠르다.
2. 중간 데이터를 추가/삭제하는 경우 LinkedList가 빠르다.

|Collection|Access time|추가/삭제|비고|
|----------|-----------|--------|---|
|ArrayList|빠르다|느리다|순차적인 추가 삭제는 더 빠름<br>비효율적인 메모리 사용|
|LinkedList|느리다|빠르다|데이터가 많을수록 접근성 떨어짐|

데이터의 개수가 변하지 않는다면 ArrayList가 최상의 선택이다.
변경이 잦다면 LinkedList를 사용하는 것이 나은 선택이 될 것이다.

두 클래스를 조합해서 쓸 수도 있다.
```java
/*처음 순차적으로 저장할 때 ArrayList 이용*/
ArrayList arraylist = new ArrayList(1000000);

for(int i=0; i<1000000;i++){
	arraylist.add(i+"");
}

/*중간에 데이터를 넣는 작업을 할 때는 LinkedList로 옮겨서 작업하면
보다 높은 효율을 얻을 수 있다.*/
LinkedList linkedList = new LinkedList(arraylist);

for(int i=0; i<1000;i++) {
	linkedList.add(500,"X");
}
```

----
# Stack & Queue
![](https://images.velog.io/images/cocodori/post/bf6c949d-2a2e-4f7d-9e31-1ac6582ac82b/1_GNA2E1NFiJMc6cTHHPa6kw.png)
<figcaption>출처 : https://gohighbrow.com/stacks-and-queues/</figcaption>

스택은 마지막에 저장한 데이터를 가장 먼저 꺼내는 Last in first out(LIFO)구조.
큐는 처음 저장한 데이터를 가장 먼저 꺼내는 First in first out(FIFO)구조다.
참고로 Stack은 클래스, Queue는 인터페이스다.

**Stack의 메서드**




|method|설명|
|----|---|
|boolean empty()|Stack이 비었는지 확인|
|Object peek()|Stack 맨 위에 저장된 객체를 반환 pop과 달리 꺼내는 것은 아님<br>비어 있다면 EmptyStackException|
|Oject pop()|맨 위에 저장된 객체를 꺼낸다. 비었다면 역시<br>EmptyStackExcption|
|Object push(Object item)|Stack에 객체를 저장한다|
|int search(Object o)|주어진 객체o를 찾아서 index를 반환<br>배열과 달리 0이 아닌 1부터 시작|



**Queue의 메서드**



|method|설명|
|-----|----|
|boolean add(Object o)|지정한 객체o를 Queue에 추가.<br>저장 공간이 부족하면 IllegalStateException|
|Ojbect remove()|객체를 꺼내 반환. 비어 있으면 NoSuchElementException|
|Object element()|삭제 없이 요소를 읽는다. peek과 달리 비었을 때 NoSuchElementException|
|boolean offer(Object o)|객체 저장|
|Object poll()|객체를 꺼내 반환, 비었으면 null|
|Object peek()|삭제 없이 요소 읽는다. 비었으면 null.|



**Stack vs. Queue**
```java
package com.javaex.ch11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new LinkedList(); //Queue인터페이스 구현체인 LinkedList

        stack.push("0");
        stack.push("1");
        stack.push("2");

        queue.offer("0");
        queue.offer("1");
        queue.offer("2");

        System.out.println("=========Stack=========");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        System.out.println("=========Queue=========");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

/*결과
=========Stack=========
2
1
0
=========Queue=========
0
1
2
*/
```

## Queue의 변형

### Dequeue
Stack과 Queue의 결합. 양끝에서 저장offer과 삭제poll가능.
구현 클래스:ArrayDeque, LinkedList

### PriorityQueue
우선순위 큐. 우선순위가 높은 것부터 꺼냄
null저장 불가.
입력 3,1,5,2,4 -> 출력 1,2,3,4,5

### Blocking Queue
비어 있을 때 꺼내기와 가득 차 있을 때 넣기를
지정된 시간동안 지연block시킴

# Arrays

배열을 다루기 편한 static메서드를 제공한다.

## 배열의 출력
toString()

```java
static String toString(boolean[] a)
static String toString(byte[] a)
static String toString(char[] a)
...
...
static String toString(Object[] a)
```

println메서드처럼 모든 타입을 출력할 수 있게 오버로딩 되어 있다.

## 배열 복사
- copyOf()
배열 전체를 복사한다.
- copyOfRange()
배열 일부를 복사한다.

```java
int[]  arr = {0,1,2,3,4};
int[] arr2 = Arrays.copyOf(arr, arr.length);	//0,1,2,34
int[] arr3 = Arrays.copyOf(arr,3)				//0,1,2
int[] arr4 = Arrays.copyOf(arr,7)				//0,1,2,3,4,0,0

int[] arr5 = Arrays.copyOfRange(arr, 2, 4);	//2,3
int[] arr6 = Arrays.copyOfRange(arr,0,7);	//0,1,2,3,4,0,0
```

## 배열 채우기
- fill()
배열의 모든 요소를 지정한 값으로 채운다.
- setAll()
배열을 채우는 데 사용할 함수형 인터페이스를 매개변수로 받는다. 이 말은 함수형 인터페이스를 구현한 객체 또는 람다식을 지정해야 한다는 것이다.

```java
int[] arr = new int[5];
Arrays.fill(arr, 9);	// [5,5,5,5,5]
Arrays.setAll(arr, ()->(int)(Math.random()*5)+1;	//1-5사이 임의의 수 5개 저장.
```
## 배열을 List로 변환
- asList(Object... a)
배열을 List로 반환한다. 매개변수의 타입 가변인수여서 배열 생성 없이 저장할 요소들만 나열하는 것도 가능하다.
```java
List list = Arrays.asList(new Integer[]{1,2,3,4,5});
List list2 = Arrays.asList(1,2,3,4,5);
list.add	// Error.
```
asList()로 반환한 List는 크기를 변경할 수 없다.
크기를 변경할 수 있는 List를 반환해야 한다면 이렇게 한다.
```java
List list = new ArrayList(Arrays.asList(1,2,3,4,5));
```


```java
public interface Comparator {
	int compare(Object o1, Object o2);
}

public interface Comparable {
	public int CompareTo(Object o);
}

```
# Comparable
 기본 정렬 기준을 구현할 때 사용한다.


# Comparator
 기본 정렬 기준 외, 다른 기준으로 정렬할 때 사용한다.
 
 ```java
package com.javaex.ch11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);    //String의 Comparable구현에 의한 정렬
        System.out.println("strArr : " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분 X
        System.out.println("strArr : " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println("strArr : " + Arrays.toString(strArr));

    }
}

class Descending implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;

            /* -1을 곱해서 역순으로 변경 */
            //return c1.compareTo(c2) * -1;

            //혹은 순서를 바꾼다.
            return c2.compareTo(c1);

        }
        return -1;
    }
}
```
# HashSet
> HashSet은 Set인터페이스를 구현한 가장 대표적인 컬렉션이다.

다시 상기하자면, Set은
- 중복 허용 X
- 순차 저장 X

중복된 데이터를 저장하려고 하면 false를 반환한다. HashSet의 특징을 이용하면 중복을 쉽게 제거할 수 있다.

**HashSet의 메서드**

|method|설명|
|------|----|
|HashSet()|(생성자)객체 생성|
|HashSet(Collection c)|지정한 컬렉션을 포함하는 객체 생성|
|HashSet(int initialCapacity)|지정한 값을 초기용량으로 하는 객체 생성|
|HashSet(int initialCapacity, float loadFactor)|초기 용량과 load factor를 지정하는 생성자|
|boolean add(Object o)| 객체 저장|
|boolean addAll(Collection c)|지정한 컬렉션에 저장된 모든 객체 저장|
|void clear()|모든 객체 삭제|
|Object clone()|복제해서 반환(얕은 복사)|
|boolean contains(Object o)|지정한 객체를 포함하고 있는지 알려준다.|
|boolean containsAll(Collection c)|지정한 컬렉션에 저장된 모든 객체를 포함하고 있는지 알려준다.|
|boolean isEmpty()|비어있는지 확인|
|Iterator iterartor()|Iterator반환|
|boolean remove(Object o)|지정한 객체 삭제|
|boolean removeAll(Collection c)|지정한 컬렉션에 저장된 객체와 동일한 것을 모두 삭제|
|boolean retainAll(Collection c)|지정한 컬렉션에 저장된 객체와 동일한 것만 남기고 모두 삭제|
|int size()|객체의 개수 반환|
|Object[] toArray()|지정한 객체를 객체 배열 형태로 반환|
|Object[] toArray(Object[] a)|지정한 객체를 주어진 객체배열a에 담는다.|

load factor는 저장공간이 가득 차기 전에 미리 용량을 확보하기 위한 것이다. 기본값은 0.75. 75% 채워지면 용량이 두 배로 늘어난다.

```java
package com.javaex.ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Bingo {
    public static void main(String[] args) {
        Set set = new HashSet();

        int[][] board = new int[5][5];

        for(int i = 0; set.size()<25;i++){
            set.add((int)(Math.random()*50)+1+"");
        }

        Iterator iterator = set.iterator();

        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length;j++) {
                board[i][j] = Integer.parseInt((String)iterator.next());
                System.out.print((board[i][j] < 10 ? "  ":" ")+board[i][j]);
            }
            System.out.println();
        }

    }
}
```
이 예제를 실행하면 같은 숫자가 비슷한 위치에 나온다는 사실을 발견할 수 있다. HashSet은 순서를 보장하지 않고 자체적인 저장방식에 따라 순서가 결정된다. 이런 경우 HashSet보다 LinkedHashSet을 쓰는 것이 더 나은 선택이다.

```java
package com.javaex.ch11;

import java.util.HashSet;

public class HashSetEx3 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");

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
    public String toString() {
        return name + " : " + age;
    }
}
/*
결과 : 
[abc, coco : 20, coco : 20]
*/
```
위 예제는 이름과 나이가 같으면 같은 사람으로 인식하려는 의도로 작성했다. 그러나 의도와 달리 결과는 두 개의 Person객체가 출력된다.

HashSet의 add()는 새로운 요소를 추가하기 전 기존 요소와 같은 것인지 판별하기 위해 추가하려는 요소의 equals()와 hashCode()를 호출하므로 두 메서드를 목적에 맞게 오버라이딩 할 필요가 있다.

```java
package com.javaex.ch11;

import java.util.HashSet;

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
```

hashCode()를 오버라이딩할 때 다음 세 가지 조건을 만족시켜야 한다.

 1. 실행 중인 애플리케이션 내 동일한 객체에 대해 여러 번 hashCode()를 호출해도 동일한 int값을 반환해야 한다. ( 실행할 때마다 동일한 값을 반환할 필요는 없다.)

 2. equals()를 이용해 true를 얻은 두 객체에 대해 각각 hashCode()를 호출해서 얻은 결과는 반드시 같아야 한다.

3. equals()를 호출했을 때 false를 반환하는 두 객체는 hashCode() 호출에 대해 같은 int를 반환하는 경우가 있어도 괜찮다. 하지만 해싱hassing을 사용하는 컬렉션 성능을 향상시키기 위해서는 다른 int값을 반환하는 것이 좋다.


# TreeSet

TreeSet은 이진 검색 트리binary search tree라는 자료구조의 형태로 데이터를 저장하는 컬렉션 클래스다. 이진 검색 트리는 정렬, 검색, 범위 검색Range Search에 높은 성능을 보인다. TreeSet은 이진 검색 트리의 성능을 향상시킨 레드-블랙 트리Red-Black tree로 구현 되었다.

![](https://images.velog.io/images/cocodori/post/8e5cdb76-c65b-4ea6-96fe-931b666fb3b8/tree.png)

Tree는 여러 개의 node가 서로 연결된 구조다. 가장 상위에 있는 노드를 root라고 한다.
위 아래로 연결된 두 노드를 부모-자식 관계라고 한다. 각 노드에 최대 2개의 노드를 연결할 수 있다.


![](https://images.velog.io/images/cocodori/post/21ae286a-7102-4208-9316-9dbc16350822/image.png)
출처 : 자바의 정석 기초편 요약집

위 표는 TreeSet에 7,4,9,1,5를 순서대로 저장한다고 했을 때 진행과정이다.

1. 맨 처음 저장되는 데이터 7이 루트root가 된다.
2. 그 다음 저장되는 값은 루트와 비교해서 루트보다 크면 오른쪽, 작으면 왼쪽에 저장된다.

이처럼 Tree구조는 검색이나 정렬에는 뛰어난 성능을 보이지만 데이터의 추가나 삭제에서는 효율이 떨어진다.

특징을 정리하면 이렇다.
- 모든 노드는 최대 두 개의 자식 노드를 가질 수 있다.
- 왼쪽 자식 노드는 부모 노드 값보다 작고, 오른쪽 자식 노드는 부모노드의 값보다 커야 한다.
- 노드의 추가, 삭제에 시간이 걸린다.
- 검색, 정렬에 유리하다.
- 중복값 저장하지 않는다.


**TreeSet의 메서드**


|method|설명|
|------|----|
|TreeSet(Collection c)|지정한 컬렉션을 가지는 TreeSet 생성|
|TreeSet(Comparator comp)|지정한 정렬조건으로 정렬하는 TreeSet생성|
|TreeSet(SortedSet s)|주어진 SortedSet을 구현한 컬렉션을 저장하는 객체 Tree Set생성|
|boolean add(Object o)<br>boolean addAll(Collecton c)|지정한 객체o 또는 Collection의 객체를 추가|
|Object ceiling(Object o)|지정한 객체와 같은 객체를 반환. 없으면 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환. 없으면 null|
|void clear()|모든 객체 삭제|
|Object clone()|객체를 복제하여 반환|
|Comparator comparator()|정렬 기준을 반환|
|boolean contains(Object o)<br>boolean containsAll(Collection c)|지정한 객체 또는 Collection의 객체를 포함하는지 확인|
|NavigableSet descendingSet()|TreeSet에 저장된 요소를 역순으로 정렬해서 반환|
|Ojbect first()|정렬된 순서에 첫 번째 객체를 반환|
|Object floor(Object o)|지정한 객체와 같은 객체를 반환. 없으면 작은 값을 가진 객체 중에서 제일 가까운 값의 객체를 반환. 없으면 null|
|SortedSet headSet(Object toElement)|지정한 객체보다 작은 값의 객체를 반환|
|NavigableSet headSet(Object toElement, boolean inclusive)|지정한 객체보다 작은 값의 객체를 반환 inclusive가 true면 같은 값 객체도 포함|
|Object higher(Object o)|지정한 객체보다 큰 값을 가진 객체 중 제일 가까운 객체를 반환, 없으면 null|
|boolean isEmpty()|TreeSet이 비었는지 확인|
|Iterator iterator()|Iterator 반환|
|Object last()|정렬한 순서에서 마지막 객체를 반환|
|Object lower(Object o)|지정한 객체보다 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환. 없으면 null|
|Object pollFirst()|첫 번째 요소(제일 작은 값의 객체)를 반환|
|Object pollLast()|마지막 번째 요소(제일 큰 값의 객체)를 반환|
|boolean remove(Object o)|지정한 객체를 삭제|
|boolean retainAll(Collection c)|주어진 컬렉션과 공통된 요소만 남기고 삭제|
|boolean size()|객체의 수 반환|
Spliterator spliterator()|Spliterator반환|
|SortedSet subSet(Object fromElement, Object toElement)|범위 검색 from~to사이의 결과를 반환. 끝 범위toElement은 포함되지 않음|
|Navigable< E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)|범위 검색. from-to사이를 반환. fromInclusvie가 true면 시작 값 포함, toInclusive가 true면 마지막값 포함|
|SortedSet tailSet(Object fromElement)|지정한 객체보다 더 큰 값의 객체를 반환|
|Object[] toArray()|저장한 객체를 객체배열로 반환|
|Object[] toArrays(Object[] a)|저장한 객체를 주어진 객체배열에 저장|

```java
package com.javaex.ch11;

import java.util.TreeSet;

public class TreeSetEx1 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abc");
        set.add("ailen");
        set.add("bat");
        set.add("car");
        set.add("Car");
        set.add("disc");
        set.add("dance");
        set.add("dZZZZ");
        set.add("dzzzz");
        set.add("elephant");
        set.add("elevator");
        set.add("fan");
        set.add("flower");

        System.out.println(set);
        System.out.println("range search : from " + from + " to : "+to);
        System.out.println("result 1 : " + set.subSet(from, to));
        System.out.println("result 2 : " + set.subSet(from,to+"zzz"));
    }
}

/*
결과 : 
[Car, abc, ailen, bat, car, dZZZZ, dance, disc, dzzzz, elephant, elevator, fan, flower]
range search : from b to : d
result 1 : [bat, car]
result 2 : [bat, car, dZZZZ, dance, disc]
*/
```

subSet("b", "d")로 지정하면
b~d사이의 문자로 시작하는 데이터를 출력한다.
마지막 문자인 d는 출력하지 않는다.

----

# HashMap

![](https://images.velog.io/images/cocodori/post/bce6ee10-50b5-469a-a889-5c7d43040256/1_bf87PsWt_buTQuzkcpsICQ.jpeg)

출처 : https://medium.com/tanay-toshniwal/count-distinct-elements-in-input-sequence-using-java-hashmaps-373a58697dd2

HashMap은 Hashtable의 페이스리프트 버전이다.

Map을 구현한 클래스의 특징은 아래와 같다.
- key, value를 묶어서 하나의 데이터entry로 저장한다.
- key는 유일unique해야 한다.
- value는 중복 가능
- 해싱hassing을 사용하므로 많은 양의 데이터를 검색할 때 뛰어난 성능을 보인다.

```java
public class HashMap extends AbstractMap implements Map, Cloneable, Serializable {
	transient Entry[] table;
    ...
    ...
    /*HashMap의 내부클래스로 Entry가 정의 되어 있다.*/
    static class Entry implements Map.Entry {	
    	final Object key;
        Object value;
        ...
    }
}
```
HashMap의 소스 일부다. key와 value를 별개의 값이 아니라 내부클래스로 정의한 다음, 하나의 배열로 다루고 있다. 이것이 데이터의 무결성(integrity)적인 측면에서 더 좋은 방법이다.

**HashMap의 메서드**


|method|설명|
|------|-----|
|HashMap(int initialCapacity)|(생성자)지정한 값을 초기 용량으로 하는 객체 생성|
|HashMap(int initialCapacity, float loadFactor)|(생성자)지정한 초기 용량과 loadFactor를 가진 객체 생성|
|HashMap(Map m)|(생성자)지정한 Map의 모든 요소를 포함하는 객체 생성)|
|void clear()|모든 객체 삭제|
|Object clone()|객체를 복사해서 반환|
|boolean containsKey(Object key)|지정한 key가 포함되어 있는지 확인|
|boolean containsValue(Object value)|지정한 value가 포함되어 있는지 확인|
|Set entrySet()|지정한 키와 값을 엔트리(key+value)의 형태로 Set에 저장해서 반환|
|Object get(Object key)|지정한 key의 매핑된 value를 반환.|
|Object getOrDefault(Object key, Object defaultValue)|지정한 key의 value를 반환. key를 못 찾으면 defaultValue로 지정한 객체를 반환|
|boolean isEmpty()|객체가 비어있는지 확인|
|Set keySet()|저장된 모든 key가 저장된 Set을 반환|
|Object put(Object key, Object value)|지정한 key와 vlaue를 저장|
|void putAll(Map m)|지정한 Map에 저장된 모든 요소를 저장|
|Object remove(Object key)|지정한 key로 저장된 객체(key+value) 제거|
|Object replace(Object key, Object value)|지정한 key의 값을 지정한 value로 대체|
|boolean replace(Object key, Object oldValue, Object newValue|지정한 key와 oldValue가 모두 일치하는 경우에만 새로운 객체newValue로 대체|
|int size()|저장된 객체의 수 반환|
|Collection values()|저장된 모든 값을 컬렉션 형태로 변환|

```java
package com.javaex.ch11;

import java.util.*;

public class HashMapEx3 {
    static HashMap phoneBook = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구","이코코","010-0000-0001");
        addPhoneNo("회사","박코코","010-0000-0002");
        addPhoneNo("회사","라코코","010-0000-0003");
        addPhoneNo("친구","파코코","010-0000-0004");
        addPhoneNo("친구","초코코","010-0000-0005");
        addPhoneNo("친구","동코코","010-0000-0006");
        addPhoneNo("회사","이코코","010-0000-0007");
        addPhoneNo("네네치킨","000-000-0000");
        printList();
    }


    //그룹에 전화번호 추가
    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);    //새 그룹 이름 만들기
        HashMap group = (HashMap)phoneBook.get(groupName);  //새로 만든 그룹 이름의 value를 불러오기
        group.put(tel, name);   //중복일 수 없는 전화번호를 key로 설정

    }

    //그룹 추가
    static void addGroup(String groupName) {
        if(!phoneBook.containsKey(groupName)){  //그룹 이름 중복 체크
            phoneBook.put(groupName, new HashMap());    //그룹 이름과 HashMap객체를 phoneBook에 추가
        }
    }

    //미분류 그룹
    static void addPhoneNo(String name, String tel) {
        addPhoneNo("기타", name, tel);
    }

    //전화번호부 전체 출력
    static void printList() {
        Set set = phoneBook.entrySet(); //Map에 저장된 객체를 Set으로 반환하는 entrySet()
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();

            Set subSet = ((HashMap)entry.getValue()).entrySet();    //value값을 subSet에 저장
            Iterator subIt = subSet.iterator();

            System.out.println(" * " +entry.getKey()+"["+subSet.size()+"]");

            while (subIt.hasNext()) {
                Map.Entry sub = (Map.Entry) subIt.next();
                String telNo = (String)sub.getKey();
                String name = (String)sub.getValue();
                System.out.println(name + " : " + telNo);
            }
            System.out.println();
        }  //end - while
    } //printList()
} //end - class


/*
결과

 * 기타[1]
네네치킨 : 000-000-0000

 * 친구[4]
동코코 : 010-0000-0006
초코코 : 010-0000-0005
이코코 : 010-0000-0001
파코코 : 010-0000-0004

 * 회사[3]
이코코 : 010-0000-0007
박코코 : 010-0000-0002
라코코 : 010-0000-0003
*/

```
HashMap은 데이터를 모두 Object타입으로 저장하기 때문에 HashMap안에 HashMap을 넣을 수 있다.

```java
package com.javaex.ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap4 {
    public static void main(String[] args) {
        String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};

        HashMap map = new HashMap();

        for(int i=0; i < data.length; i++) {
            if(map.containsKey(data[i])) { //map에 저장된 key 중에 data[i]가 있다면,
                Integer value = (Integer)map.get(data[i]);  //key의 value를 Integer에 저장.
                /*
                ???value.intValue()와 value의 결과값이 같은데 왜 intValue()를 쓸까?
                */
                map.put(data[i], value.intValue() + 1); //map에 data[i]와, value+1 값을 저장
            } else {
                map.put(data[i], 1);   //없다면 map에 data[i]의 값과, 1을 저장
            }
        } // end - for

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry =(Map.Entry) iterator.next();
            int value = ((Integer)entry.getValue()).intValue();
//            System.out.println("entry.getKey() : " + entry.getKey());
//            System.out.println("entry.getValue() : " + entry.getValue());
            System.out.println(entry.getKey() + " : " + printBar('#',value)+ " " + value);
        }
    } //main()

    public static String printBar(char ch, int value) {
        char[] bar = new char[value];

        for (int i = 0; i < bar.length; i++) {
            bar[i] = ch;
        }
            return new String(bar);
    }
}
```

위 코드 진행 과정

1. 문자열 배열에 담긴 문자열을 하나씩 읽어서 HashMap에 key로 저장, 값으로 1을 저장한다.
2. HashMap에 같은 문자열이 같은 문자열이 키로 저장되어있는지 containsKey()로 확인한다.
3. 있다면 저장되어 있는 문자열의 value를 +1한다.
4. printBar()를 이용해서 그래프로 표현한다.

----

- *잘못된 내용이 있을 수 있습니다.*
# 해싱과 해시함수
>해싱이란 해시함수를 이용해서 데이터를 헤시테이블에 저장하고 검색하는 기법이다.
해시함수는 데이터가 저장되어 있는 곳을 알려주므로 다량의 데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다.

해싱을 구현한 클래스로 HashSet, HashMap, Hashtable 등이 있다. Hashtable은 컬렉션프레임웍 도입(JDK1.8)이후 HashMap으로 대체 되었다.

# 해싱의 자료 구조

![](https://images.velog.io/images/cocodori/post/94aa8993-8b07-40ce-888e-183f7b6374f7/KakaoTalk_20200730_185706900.jpg)

HashMap을 이용해 아주 복잡한 이름을 가진 모델명과 제조사를 묶어서 데이터를 보관해둔다고 하자. 나는 이 복잡한 이름의 모델명을 가진 제품의 제조사를 자주 구분해야 할 필요가 있다. 중복되지 않는 모델명을 key로 두고 언제든 key를 이용해 value에 접근할 수 있게 만든다면 이렇게 할 것이다.

|아주 복잡한 이름의 제품 모델명|
|----|
|GalaxyNote10|
|iphoneXS|
|GalaxyS20|
|iphone5|
|G10|
|GoolgePhone1|


이 분류가 위 그림에서 Array부분에 해당한다.
그 다음은 중복을 허용하는 value 부분에 제조사를 추가한다.


|아주 복잡한 이름의 제품 모델명|제조사|
|----|----|
|GalaxyNote10|apple|
|iphoneXS|apple|
|GalaxyS20|Samsung|
|iphone5|Samsung|
|G10|LG|
|GoolgePhone1|Google|



정리하자면, 해싱에 사용되는 자료구조(Array+LinkedList)에서
분류는 Array, 실제 데이터는 LinkedList로 저장한다.

이러면 언제든지, 필요할 때마다 이 복잡한 이름의 제품을 어떤 회사가 만들었는지 쉽게 알 수 있다.

아래는 원하는 요소를 찾는 과정이다.

![](https://images.velog.io/images/cocodori/post/5c2c0375-7138-45dc-ac92-76f9b5c2a1ab/KakaoTalk_20200730_190558186.jpg)


1. 검색할 key로 해시함수 호출
2. 해시함수 결과(hash code)로 해당 값이 저장된 LinkedList를 찾는다.
3. 최종 결과 값 반환(apple)

하나의 key에 여러 LinkedList를 저장할 수 있지만 그렇게하면 성능이 떨어진다. 알다시피 LinkedList는 검색에 취약하기 때문이다. 따라서 하나의 key에 하나의 LinkedList만 저장해두는 것이 좋다.
 - HashMap의 크기를 적절히 지정한다.
 - 해시함수가 다른 key에 대해 중복된 해시코드를 반환을 최소화 한다.
 
그래서 해싱을 구현할 때 중요한 것은 해시함수 알고리즘이다. 보통은 HashMap과 같이 해싱을 구현한 컬렉션 클래스에서는 Object클래스에 정의된 hashCode()를 해시함수로 사용한다. hashCode()는 객체의 주소를 이용하는 알고리즘으로 해시코드를 만들기 때문에 모든 객체에 대해 hashCode()를 호출한 결과가 다르다. 좋은 방법이다.

String클래스의 경우, Object에서 상속받은 hashCode()를 오버라이딩해서 문자열의 내용으로 해시코드를 만든다. 따라서 다른 String인스턴스라고 해도, 문자열이 같다면 같은 해시코드를 반환한다.
equals()로 비교환 결과가 true인 동시에 hashCode()의 반환값이 같아야 같은 객체로 인식한다. HashMap도 마찬가지며, 이미 존재하는 key값을 저장하면 기존 값을 새로운 값으로 덮어쓴다.


참고:자바의 정석


----
![](https://images.velog.io/images/cocodori/post/0efdd9ff-a56a-4508-bcc3-d28a436b6f8e/1_TuJ3FO1cxXR12fNZAlWF0Q.jpeg)
이미지 출처 : https://adrianmejia.com/data-structures-for-beginners-trees-binary-search-tree-tutorial/

트리구조.

# TreeMap

![](https://images.velog.io/images/cocodori/post/2738e249-0fbc-4f4a-8af7-1e80da9d9412/treeMap.jpg)
이미지 출처 : https://www.java8net.com/2020/02/treemap-in-java.html


TreeMap은 이름에서 알다시피 이진검색트리 형태에 key와 value 쌍으로 이루어진 데이터를 저장한다.
- 검색과 정렬에 적합한 컬렉션 클래스다.
범위 검색은 TreeMap이 성능이 좋지만, 그게 아니라면 검색 부분에서는 HashMap 성능이 더 좋다.

**TreeMap의 메서드**

|method|설명|
|------|-----|
|TreeMap(Comparator c)|지정한 Comparator를 기준으로 정렬하는 객체 생성|
|TreeMap(Map m)|주어진 Map에 저장된 요소를 포함하는 객체 생성|
|TreeMap(SortedMap m)|주어진 SortedMap에 저장된 모든 요소를 포함하는 객체 생성|
|Map.Entry ceilingEntry(Object key)|지정한 key와 일치하거나, 큰 것 중 제일 작은 Map.Entry(key-value) 반환. 없으면 null.|
|Object ceilingKey(Object key)|지정한 key와 일치하거나 큰 것중 제일 작은 key를 반환. 없으면 null|
|void clear()|모든 객체 삭제|
|Object clone()|현재 객체를 복제해서 반환|
|Comparator comparator()|TreeMap의 정렬기준이 되는 Comparator를 반환.<br>Comparator가 지정되지 않았다면 null|
|boolean containsKey(Object key|TreeMap에 지정한 key가 포함되어 있는지 확인|
|boolean containsValue(Object value)|지정한 value를 포함하는지 확인|
|NavigableSet descendingKeySet()|저장된 키를 역순으로 정렬해서 NavigableSet으로 반환|
|Set entrySEt()|엔트리(key+value)를 (Set타입)반환|
|Map.entry firstEntry()|첫 번째(가장 작은) key-value를 반환|
|Object firstKey()|첫 번째(가장 작은) key를 반환|
|Map.Entry floorEntry(Object key)|지정한 key와 일치하거나 작은 것 중에 제일 큰 key의 key-value를 반환.|
|Object floorKey(Object key)|지정한 key와 일치하거나 작은 것 중, 제일 큰 키를 반환.|
|Object get(Object key)|지정한 key의 value를 반환|
|SortedMap headMap(Object toKey)|TreeMap에 저장된 첫 번째 요소부터 지정한 범위에 속한 모든 요소가 담긴 SortedMap을 반환. (toKey 포함)|
|NavigableMap headMap(Object toKey, boolean inclusive)|TreeMap에 저장된 첫 번째 요소부터 지정한 범위toKey에 속한 모든 요소가 담긴 SortedMap을 반환. inclusive가 true면 toKey도 포함|
|Map.Entry highherEntry(Object key|지정한 key보다 큰 키 중에서, 제일 작은 key-value를 반환.|
|Object higherKey(Object key)|지정한 key보다 큰 키 중에서 제일 작은 key-value를 반환|
|boolean isEmpty()|객체가 비었는지 확인|
|Set keySet()|객체에 저장된 모든 key를 포함하는 Set반환|
|Map.Entry lastEntry()|객체에 저장된 마지막 key(가장 큰 키)-value 반환|
|Object lastKey()|TreeMap에 저장된 마지막 키(가장 큰 키)를 반환|
|Map.Entry lowerEntry(Object key)|지정한 key보다 작은 key중에서 제일 큰 key-value를 반환|
|Object lowerKey(Object key)|지정한 key보다 작은 key중에서 제일 큰 key-value를 반환|
|NavigableSet navigableKeySet()|모든 key가 담긴 NavigableSet을 반환|
|Map.Entry().pollFirstEntry()|객체에서 제일 작은 key를 제거하면서 반환|
|Map.Entry().pollLastEntry()|객체에서 제일 큰 key를 제거하면서 반환|
|Object put(Object key, Object value)|지정한 key, value를 저장|
|void putAll(Map map)|지정한 Map에 포함된 모든 요소를 저장|
|Object remove(Object key)|지정한 key로 저장된 객체key-value를 제거|
|Object replace(Object k,Object v)|기존의 key(k)의 value를 새로운 value(v)로 변경|
|boolean replace(Object key, Object oldValue, Object newValue)|기존의 key의 value를 새로운 newValue로 변경. 단, 기존의 value와 oldValue가 일치해야 함.|
|int size()|저장된 객체의 수 반환|
|NavigableMap subMap(Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive)|지정한 두 개의 키 사이에 있는 모든 요소가 담긴 NavagableMap반환. fromInclusive, toInclusive가 true면 범위에 포함.|
|SortedMap subMap(Object fromKey, Object toKey)|지정한 키 사이에 있는 모든 요소가 담긴 SortedMap반환. (toKey 미포함)|
|SortedMap tailMap(Object fromKey)|지정한 키부터 마지막 요소까지 반환|
|NavigableMap(Object fromKey, boolean inclusive)|지정한 키부터 마지막 요소까지 반환. inclusive가 true면 fromKey 포함.|
|Collection values()|저장된 모든 객체를 Collecton타입으로 반환|


```java
package com.javaex.ch11;

import java.util.*;

public class TreeMapEx1 {
    public static void main(String[] args) {
        String[] data = {"A", "K", "A", "K", "D","K","A","K","K","K","K","Z","D"};

        TreeMap map = new TreeMap();

        for (int i = 0; i < data.length; i ++) {
            if(map.containsKey(data[i])) {
                Integer value = (Integer)map.get(data[i]);
                map.put(data[i],value+1);
            } else {
                map.put(data[i], 1);
            }
        }

        Iterator iterator = map.entrySet().iterator();

        System.out.println("==기본정렬==");
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
        }
        System.out.println();

        //map -> ArrayList -> Collections.sort() 정렬
        Set set = map.entrySet();
        List list = new ArrayList(set);

        //static void sort(List list, Comparator c)
        Collections.sort(list, new Comparator() {   //익명클래스
            @Override
            public int compare(Object o1, Object o2){
                if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
                    Map.Entry entry1 = (Map.Entry) o1;
                    Map.Entry entry2 = (Map.Entry) o2;

                    int value1 =((Integer)entry1.getValue()).intValue();
                    int value2 =((Integer)entry2.getValue()).intValue();

                    return value2 - value1;
                }
                return -1;
            }
        });

        iterator = list.iterator();

        System.out.println("==값의 크기가 큰 순서로 정렬==");
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            int value = ((Integer)entry.getValue()).intValue();
            System.out.println(entry.getKey() + " : " + printBar('#',value) + " " + value);
        }

    } //main()

    public static String printBar(char ch, int value) {
        char[] bar = new char[value];

        for(int i = 0; i < bar.length; i ++) {
            bar[i] = ch;
        }

        return new String(bar);
    }
}

```

위 예제는 [HashMap을 이용한 예제](velog.io/@cocodori/Map)를 TreeMap으로 변경한 것이다. String클래스에 정의된 기본 정렬과, Comparator를 구현한 정렬을 비교한 것이다.

참고로 익명클래스를 이용해 구현한 부분은 람다를 이용해 조금 더 간단히 쓸 수 있다.

```java
        Collections.sort(list, (Object o1, Object o2) -> {   //람다
                if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
                    Map.Entry entry1 = (Map.Entry) o1;
                    Map.Entry entry2 = (Map.Entry) o2;

                    int value1 =((Integer)entry1.getValue()).intValue();
                    int value2 =((Integer)entry2.getValue()).intValue();

                    return value2 - value1;
                }
                return -1;
        });
```

이렇게 바꾸면 좀 더 심플한 코드가 된다.







