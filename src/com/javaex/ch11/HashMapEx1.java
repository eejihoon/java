package com.javaex.ch11;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("myId","1234");
        map.put("asdf","1111");
        map.put("asdf","1234"); //map은 중복된 key를 저장하면 기존 데이터에 덮어쓴다.

        Scanner scanner = new Scanner(System.in);   //콘솔에서 라인단위로 입력

        while (true) {
            System.out.println("아이디와 패스워드를 입력하세요.");
            System.out.print("아이디 : ");
            String id = scanner.nextLine().trim();

            System.out.print("비밀번호를 입력하세요.");
            String password = scanner.nextLine().trim();
            System.out.println();

            if(!map.containsKey(id)) {
                System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
                continue;
            } else {
                if(!(map.get(id)).equals(password)) {
                    System.out.println("비밀번호가 틀렸습니다.");
                } else {
                    System.out.println("로그인 완료");
                    break;
                }

            }

        }
    }
}
