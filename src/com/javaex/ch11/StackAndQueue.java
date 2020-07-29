package com.javaex.ch11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new LinkedList(); //Queue인터페이스 구현체인 LinkedList

        stack.push("0");
        stack.push("1");
        stack.push("2");

        queue.offer("0");
        queue.offer("1");
        queue.offer("2");

        System.out.println("=========Stack=========");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        System.out.println("=========Queue=========");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
