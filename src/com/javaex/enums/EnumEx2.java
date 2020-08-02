package com.javaex.enums;

public class EnumEx2 {
    public static void main(String[] args) {
        for (Direction direc : Direction.values()) {
            System.out.printf("%s = [ %d %s ] %n", direc.name(), direc.getValue(), direc.getSymbol());
        }

        Direction direction1 = Direction.EAST;
        Direction direction2 = Direction.of(1);

        System.out.printf("diretion1 = [ %s , %d ] %n", direction1.name(),direction1.getValue());
        System.out.printf("diretion2 = [ %s , %d ] %n", direction2.name(),direction2.getValue());

        System.out.println(Direction.EAST.rotate(1));   //90도 회전
        System.out.println(Direction.EAST.rotate(2));   //180도 회전
        System.out.println(Direction.EAST.rotate(3));   //270도 회전
        System.out.println(Direction.EAST.rotate(4));   //360도

        System.out.println(Direction.EAST.rotate(-1));  //시계 반대 방향
    }
}

enum Direction {
    /*값을 직접 지정*/
    EAST(1, "→"),
    SOUTH(2, "↓"),
    WEST(3, "←"),
    NORTH(4, "↑");

    /*enum에 멤버 추가
     * 반드시 final이어야 할 필요는 없다.
     * 다만 value는 열거형 상수의 값을 저장하기 위한 것이므로 final을 붙였다.
     * */
    //Directoin배열에 Direction에 선언된 모든 상수를 저장.
    private static final Direction[] DIR_ARR = Direction.values();
    private final int value;
    private final String symbol;

    //생성자
    private Direction(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return this.value;
    }

    public String getSymbol() {
        return this.symbol;
    }

    /*입력 받은 방향을 반환하는 메서드*/
    public static Direction of(int dir) {
        if (dir < 1 || dir > 4) {   //유효성 검사
            throw new IllegalArgumentException("Invalid value :" + dir);
        }

        return DIR_ARR[dir - 1];
    }

    /*방향을 회전하는 메서드. num의 값만큼 90도씩 시계방향으로 회전*/
    public Direction rotate(int num) {
        num = num % 4;

        //num이 음수일 때는 시계반대방향으로 회전
        if (num < 0) {
            num += 4;
        }

        return DIR_ARR[(value - 1 + num) % 4];
    }

    @Override
    public String toString() {
        return name() + getSymbol();
    }

}   //end - class


