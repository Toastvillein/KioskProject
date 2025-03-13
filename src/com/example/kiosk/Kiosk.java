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
    // List 객체 생성 및 MenuItem 객체값 할당
    private List<MenuItem> menuItems = new ArrayList<>(
            List.of(
                    new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                    new MenuItem("SmokeBurger", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                    new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                    new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거")
            )
    );
    // Menu 객체 생성 및 위에서 생성한 List 객체 할당
    Menu menu = new Menu(menuItems);
    ShoppingCart cart = new ShoppingCart();

    // start() 메서드
    public void start() {
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
                int categoryChoice = scanner.nextInt();
                if (categoryChoice == 1) {
                    menu.showMenuitem();
                    System.out.println("0. 뒤로가기");
                } else if (categoryChoice==4 && !cart.cartMap.isEmpty()) {
                    System.out.println("아래와 같이 주문 하시겠습니까?"+System.lineSeparator());
                    System.out.println("[Orders]");
                    cart.showCart();
                    System.out.println("[Total]");
                    System.out.println(cart.fullPrice()+"원");
                    System.out.println(System.lineSeparator()+"1.주문  2.돌아가기");
                    int discountChoice = scanner.nextInt();
                    if (discountChoice==1){
                        System.out.println("할인 정보를 입력해주세요."+System.lineSeparator()+
                                "1. 국가유공자 : 10%"+System.lineSeparator()+
                                "2. 군인 : 5%"+System.lineSeparator()+
                                "3. 학생 : 3%"+System.lineSeparator()+
                                "4. 일반 : 0%");
                        int orderChoice = scanner.nextInt();
                        switch (orderChoice){
                            case 1:
                                System.out.println("주문이 완료되었습니다. 금액은 "+(cart.fullPrice()-
                                        UserDiscount.MERITORIOUS.doDicount(cart.fullPrice()))+"원 입니다.");
                                break;
                            case 2:
                                System.out.println("주문이 완료되었습니다. 금액은 "+(cart.fullPrice()-
                                        UserDiscount.SOLDIER.doDicount(cart.fullPrice()))+"원 입니다.");
                                break;
                            case 3 :
                                System.out.println("주문이 완료되었습니다. 금액은 "+(cart.fullPrice()-
                                        UserDiscount.STUDENT.doDicount(cart.fullPrice()))+"원 입니다.");
                                break;
                            case 4:
                                System.out.println("주문이 완료되었습니다. 금액은 "+cart.fullPrice()+"원 입니다.");
                                break;
                        }   break;

                    } else if (discountChoice==2) {
                        System.out.println("메뉴로 돌아갑니다.");
                        continue;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                        continue;
                    }
                } else if (categoryChoice==5 && !cart.cartMap.isEmpty()) {
                    try {
                        System.out.println("진행 중인 주문을 취소합니다.");
                        continue;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (categoryChoice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("해당하는 카테고리가 없습니다. 처음으로 되돌아갑니다.");
                    continue;
                }

                int menuChoice = scanner.nextInt();

                if (menuChoice != 0) {
                    try {
                        System.out.println(menu.getItemList().get(menuChoice - 1).getBurgerName() + "를 고르셨습니다. "
                                + menu.getItemList().get(menuChoice - 1).getBurgerPrice() + "원입니다.");
                        System.out.println("장바구니에 추가 하시겠습니까?");
                        System.out.println("1.추가    2.취소");
                        int cartChoice = scanner.nextInt();
                        if (cartChoice == 2) {
                            System.out.println("메뉴로 돌아갑니다.");
                            continue;
                        } else if (cartChoice == 1) {
                            System.out.println("장바구니에 추가 되었습니다.");
                            System.out.println("장바구니 목록");
                            cart.addCart(menu.getItemList().get(menuChoice - 1), 0);
                            cart.showCart();
                        }
                        Thread.sleep(1500);
                    } catch (Exception e) {
                        System.out.println("해당하는 메뉴가 없습니다.");
                        throw new RuntimeException(e);
                    }
                } else if (menuChoice == 0) {
                    System.out.println("카테고리 선택메뉴로 돌아갑니다.");
                    continue;
                }
        }



    }
}
