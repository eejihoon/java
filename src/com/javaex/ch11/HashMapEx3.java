package com.javaex.ch11;

import java.util.*;

public class HashMapEx3 {
    static HashMap phoneBook = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구","이코코","010-0000-0001");
        addPhoneNo("회사","박코코","010-0000-0002");
        addPhoneNo("회사","라코코","010-0000-0003");
        addPhoneNo("친구","파코코","010-0000-0004");
        addPhoneNo("친구","초코코","010-0000-0005");
        addPhoneNo("친구","동코코","010-0000-0006");
        addPhoneNo("회사","이코코","010-0000-0007");
        addPhoneNo("네네치킨","000-000-0000");
        printList();
    }


    //그룹에 전화번호 추가
    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);    //새 그룹 이름 만들기
        HashMap group = (HashMap)phoneBook.get(groupName);  //새로 만든 그룹 이름의 value를 불러오기
        group.put(tel, name);   //중복일 수 없는 전화번호를 key로 설정

    }

    //그룹 추가
    static void addGroup(String groupName) {
        if(!phoneBook.containsKey(groupName)){  //그룹 이름 중복 체크
            phoneBook.put(groupName, new HashMap());    //그룹 이름과 HashMap객체를 phoneBook에 추가
        }
    }

    //미분류 그룹
    static void addPhoneNo(String name, String tel) {
        addPhoneNo("기타", name, tel);
    }

    //전화번호부 전체 출력
    static void printList() {
        Set set = phoneBook.entrySet(); //Map에 저장된 객체를 Set으로 반환하는 entrySet()
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();

            Set subSet = ((HashMap)entry.getValue()).entrySet();    //value값을 subSet에 저장
            Iterator subIt = subSet.iterator();

            System.out.println(" * " +entry.getKey()+"["+subSet.size()+"]");

            while (subIt.hasNext()) {
                Map.Entry sub = (Map.Entry) subIt.next();
                String telNo = (String)sub.getKey();
                String name = (String)sub.getValue();
                System.out.println(name + " : " + telNo);
            }
            System.out.println();
        }  //end - while
    } //printList()
} //end - class
