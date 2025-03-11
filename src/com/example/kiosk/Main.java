package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
        // Kiosk 내 start() 메서드 실행
        Kiosk kiosk = new Kiosk();
        kiosk.start(menu);
    }
}

