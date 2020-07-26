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
