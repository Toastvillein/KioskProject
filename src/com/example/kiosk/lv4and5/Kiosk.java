package com.example.kiosk.lv4and5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 카테고리 리스트
    private List<Menu> categoryList = new ArrayList<>(
            List.of(new Menu("Burgers"),
                    new Menu("Drinks"),
                    new Menu("Desserts")
            )
    );
    // List 객체 생성 및 MenuItem 객체값 할당
    List<MenuItem> menuItems = new ArrayList<>(
            List.of(
                    new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                    new MenuItem("SmokeBurger", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                    new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                    new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거")
            )
    );
    // Menu 객체 생성 및 위에서 생성한 List 객체 할당
    Menu menu = new Menu(menuItems);
    // start() 메서드
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHAK MENU ]");
            for (int i=0; i< categoryList.size(); i++ ) {
                System.out.print(i+1+". ");
                System.out.println(categoryList.get(i).getCategory());
            }
            System.out.println("0. 종료      | 종료");
            int choice1 = scanner.nextInt();
            if (choice1==1) {
                menu.showMenuitem();
            } else if (choice1==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("해당하는 카테고리가 없습니다. 처음으로 되돌아갑니다.");
                continue;
            }

            int choice2 = scanner.nextInt();

            if(choice2!=0){
                try {
                    System.out.println(menu.getItemList().get(choice2-1).getBurgerName() + "를 고르셨습니다. "
                            + menu.getItemList().get(choice2-1).getBurgerPrice() + "원입니다.");
                    Thread.sleep(1500);
                } catch (Exception e) {
                    System.out.println("해당하는 메뉴가 없습니다.");
                    throw new RuntimeException(e);
                }
            }

        }
    }
}