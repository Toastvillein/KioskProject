package com.example.kiosk;

import java.util.*;

public class Kiosk {
    // 카테고리 리스트
    private List<Menu> categoryList = new ArrayList<>(
            List.of(new Menu("Burgers"),
                    new Menu("Drinks"),
                    new Menu("Desserts")
            )
    );
    ShoppingCart cart = new ShoppingCart();

    // start() 메서드
    public void start(Menu menu) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[SHAKESHAK MENU]");
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(categoryList.get(i).getCategory());
            }
            System.out.println("0. 종료");
            if (!cart.cartMap.isEmpty()) {
                System.out.println("[Order Menu]");
                System.out.println("4. Orders");
                System.out.println("5. Cancel");
            }
                int choice1 = scanner.nextInt();
                if (choice1 == 1) {
                    menu.showMenuitem();
                    System.out.println("0. 뒤로가기");
                } else if (choice1==4 && !cart.cartMap.isEmpty()) {
                    System.out.println("아래와 같이 주문 하시겠습니까?"+System.lineSeparator());
                    System.out.println("[Orders]");
                    cart.showCart();
                    System.out.println("[Total]");
                    cart.fullPrice();
                    System.out.println(System.lineSeparator()+"1.주문  2.돌아가기");
                    int choice4 = scanner.nextInt();
                    if (choice4==1){
                        System.out.print("주문이 완료되었습니다. 금액은");
                        cart.fullPrice();
                        System.out.println(" 입니다.");
                        break;
                    } else if (choice4==2) {
                        System.out.println("메뉴로 돌아갑니다.");
                        continue;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                        continue;
                    }
                } else if (choice1==5 && !cart.cartMap.isEmpty()) {
                    try {
                        System.out.println("진행 중인 주문을 취소합니다.");
                        continue;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (choice1 == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("해당하는 카테고리가 없습니다. 처음으로 되돌아갑니다.");
                    continue;
                }

                int choice2 = scanner.nextInt();

                if (choice2 != 0) {
                    try {
                        System.out.println(menu.getItemList().get(choice2 - 1).getBurgerName() + "를 고르셨습니다. "
                                + menu.getItemList().get(choice2 - 1).getBurgerPrice() + "원입니다.");
                        System.out.println("장바구니에 추가 하시겠습니까?");
                        System.out.println("1.추가    2.취소");
                        int choice3 = scanner.nextInt();
                        if (choice3 == 2) {
                            System.out.println("메뉴로 돌아갑니다.");
                            continue;
                        } else if (choice3 == 1) {
                            System.out.println("장바구니에 추가 되었습니다.");
                            System.out.println("장바구니 목록");
                            cart.addCart(menu.getItemList().get(choice2 - 1), 0);
                            cart.showCart();
                        }
                        Thread.sleep(1500);
                    } catch (Exception e) {
                        System.out.println("해당하는 메뉴가 없습니다.");
                        throw new RuntimeException(e);
                    }
                } else if (choice2 == 0) {
                    System.out.println("카테고리 선택메뉴로 돌아갑니다.");
                    continue;
                }
        }



    }
}
