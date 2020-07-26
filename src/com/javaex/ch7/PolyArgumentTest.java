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
