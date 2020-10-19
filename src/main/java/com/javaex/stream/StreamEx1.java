package com.javaex.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김콩콩", 1, 200),
                new Student("박쏘쏘", 2, 100),
                new Student("이빵떡", 2, 150),
                new Student("최노잼", 3, 290),
                new Student("황꽁꽁", 3, 180)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan)  //반별 정렬
        .thenComparing(Comparator.naturalOrder()))                  //기본 정렬
        .forEach(element -> System.out.println(element));
    }


}

class Student implements Comparable<Student> {
    private String name;
    private int ban;
    private int totalScore;

    public String getName() {
        return this.name;
    }

    public int getBan() {
        return this.ban;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "name : " + name + " , ban : " + ban + " , totalScore : " + totalScore ;
    }

    @Override
    public int compareTo(Student o) {
        return o.totalScore - this.totalScore;
    }
}
