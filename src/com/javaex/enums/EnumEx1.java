//package com.javaex.enums;
//
///*enum 정의*/
//enum Direction {
//    EAST,
//    SOUTH,
//    WEST,
//    NORTH
//}
//
//public class EnumEx1 {
//    public static void main(String[] args) {
//        /*enum 사용*/
//        Direction direction1 = Direction.EAST;
//        Direction direction2 = Direction.valueOf("WEST");
//
//        //지정한 enum에서 name과 일치하는 열거형 상수를 반환한다.
//        //T valueOf(Class<T> enumType, String name)
//        Direction direction3 = Enum.valueOf(Direction.class, "EAST");
//
//        //enum 비교
//        System.out.println("direction1 : " + direction1);
//        System.out.println("direction2 : " + direction2);
//        System.out.println("direction3 : " + direction3);
//        System.out.println("direction1 == direction2 ? " + (direction1 == direction2));
//        System.out.println("direction1 == direction3 ? " + (direction1 == direction3));
//        System.out.println("direction1.equals(direction3) ? " + direction1.equals(direction3));
//        System.out.println("direction1.compareTo(direction3) ? " + direction1.compareTo(direction3));
//        System.out.println("direction1.compareTo(direction2) ? " + direction1.compareTo(direction2));
//
//    }
//}
