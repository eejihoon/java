package com.javaex.ch7;

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
		this(100, 200, 300);	//Point3D(int x, int y, int z) ȣ��
	}
	
	Point3D(int x, int y, int z) {
		super(x, y); //	PointXY(int x, int y) ȣ��
		this.z = z;
	}
	
}
