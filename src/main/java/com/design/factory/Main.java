package com.design.factory;

/*
*   현실 세계에서 팩토리는 물건을 생성한다. 객체지향의 세계에서 팩토리는 객체를 생성한다.
*   결국 팩토리 메서드는 객체를 생성해서 반환하는 메서드를 말한다. 여기 '패턴'이 붙으면 하위 클래스에서
*   팩토리 메서드를 오버라이딩해서 객체를 반환한다는 말이다.
* */
public class Main {
    public static void main(String[] args) {
        //팩토리 메서드를 보유한 객체 생성
        Animal bolt = new Dog();
        Animal kitty = new Cat();

        //팩토리 메서드가 반환하는 객체
        AnimalToy boltToy = bolt.getToy();
        AnimalToy kittyToy = kitty.getToy();

        //팩토리 메서드가 반환한 객체 사용
        boltToy.identify();
        kittyToy.identify();
    }
}

interface Animal {
    AnimalToy getToy();
}

interface AnimalToy {
    void identify();
}

class DogToy implements AnimalToy{
    @Override
    public void identify() {
        System.out.println("나는 도그 토이! 도그의 친구");
    }
}

class CatToy implements AnimalToy {
    @Override
    public void identify() {
        System.out.println("아 머 캣 타워! 마 프렌디즈 캣!");
    }
}

class Cat implements Animal {
    //객체를 반환하는 팩토리 메서드
    @Override
    public AnimalToy getToy() {
        return new CatToy();
    }
}

class Dog implements Animal {
    //객체를 반환하는 팩토리 메서드
    @Override
    public AnimalToy getToy() {
        return new DogToy();
    }
}




