package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> itemList = new ArrayList<>();

    // List의 생성자
    public Kiosk(List<MenuItem> itemList) {
        this.itemList = itemList;
    }

    // start() 메서드
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHAK MENU ]");

            for (int i=0; i< itemList.size(); i++ ) {
                System.out.print(i+1+". ");
                System.out.println(itemList.get(i));
            }
            System.out.println("0. 종료      | 종료");
            int choice = scanner.nextInt();

            if(choice!=0){
                try {
                    System.out.println(itemList.get(choice-1).getBurgerName() + "를 고르셨습니다. " + itemList.get(choice-1).getBurgerPrice() + "원입니다.");
                    Thread.sleep(1500);
                } catch (Exception e) {
                    System.out.println("해당하는 메뉴가 없습니다.");
                    throw new RuntimeException(e);
                }
            } else if (choice==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
