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




