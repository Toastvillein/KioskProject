package com.example.kiosk.challv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Menu {
    // MenuItem 클래스를 관리하는 클래스
    // 버거 음료 메뉴 등 각 카테고리 내에 여러 아이템을 포함함
    // 카테고리 이름 필드 추가
    private String category;

    //List<MenuItem>을 가져와서 관리하도록 변경
    List<MenuItem> itemList = new ArrayList<>();

    // itemList의 생성자
    public Menu(List<MenuItem> itemList) {
        this.itemList = itemList;
    }
    // category의 생성자
    public Menu (String category){
        this.category = category;
    }

    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
//    public void showMenuitem(){
//        for (int i=0; i< itemList.size(); i++ ) {
//            System.out.print(i+1+". ");
//            System.out.println(itemList.get(i));
//        }
//    }
    public void showMenuitem(){
        IntStream.range(0, itemList.size())
                .forEach(i -> System.out.println((i+1)+"."+itemList.get(i)));
    }

    // 내가 생각했던 스트림 구조
    // List<MenuItem> result = itemList.stream().중간연산자().최종연산자();


    // category 게터
    public String getCategory() {
        return category;
    }

    // List를 리턴하는 함수
    public List<MenuItem> getItemList() {
        return itemList;
    }

}
