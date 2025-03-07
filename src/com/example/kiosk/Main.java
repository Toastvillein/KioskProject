package com.example.kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        MenuItem menuItem1 = new MenuItem("ShackBurger",6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem2 = new MenuItem("SmokeShack",8900,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem3 = new MenuItem("Cheeseburger",6900,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem menuItem4 = new MenuItem("Hamburger",5400,"비프패티를 기반으로 야채가 들어간 기본버거");
        itemList.add(menuItem1);
        itemList.add(menuItem2);
        itemList.add(menuItem3);
        itemList.add(menuItem4);


        while (true) {
            System.out.println("[ SHAKESHAK MENU ]");
            System.out.println("1."+ itemList.get(0));
            System.out.println("2."+ itemList.get(1));
            System.out.println("3."+ itemList.get(2));
            System.out.println("4."+ itemList.get(3));
            System.out.println("0. 종료      | 종료");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("ShackBurger를 고르셨습니다. 6900원입니다.");
                    break;
                case 2:
                    System.out.println("SmokeShack를 고르셨습니다. 8900원입니다.");
                    break;
                case 3:
                    System.out.println("Cheeseburger를 고르셨습니다. 6900원입니다.");
                    break;
                case 4:
                    System.out.println("Hamburger를 고르셨습니다. 5400원입니다.");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못입력하셨습니다");
            }
            if (choice == 0) {
                break;
            }
        }
    }
}
