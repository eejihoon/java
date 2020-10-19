package com.javaex.ch6;
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

	@Override
	public String toString() {
		return "CarCompo [color=" + color + ", gearType=" + gearType + ", door=" + door + "]";
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
