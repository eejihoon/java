package com.javaex.ch6;

class Ironman {
    static String tonyStark = "robertDowneyJr";
}

public class Avengers {
    public static void main(String[] args) {
        Ironman iron1 = new Ironman();
        Ironman iron2 = new Ironman();

        System.out.println("================BEFORE====================");
        System.out.println("Ironman.tonyStark : " + Ironman.tonyStark);

        Ironman.tonyStark = "James Gosling";

        System.out.println("================AFTER====================");
        System.out.println("Ironman.tonyStark : " + Ironman.tonyStark);

        System.out.println("------------------------------------------");

        System.out.println("iron1.tonyStark : " + iron1.tonyStark);
        System.out.println("iron2.tonyStark : " + iron2.tonyStark);

        iron1.tonyStark = "STATIC is shared.";

        System.out.println("--------------------------------------------");
        System.out.println("iron1.tonyStark : " + iron1.tonyStark);
        System.out.println("iron2.tonyStark : " + iron2.tonyStark);

    }

}