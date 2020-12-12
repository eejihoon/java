package com;

import java.util.stream.IntStream;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 2; i < 10; i++)
            for (int j = 1; j < 10; j++)
                System.out.printf("%d * %d = %d%n", i, j, i * j);


        IntStream.range(2, 10).forEach(i -> {
            IntStream.range(1, 10).forEach(j -> {
                System.out.printf("%d * %d = %d%n", i,j,i*j);
            });
        });

    }

}
