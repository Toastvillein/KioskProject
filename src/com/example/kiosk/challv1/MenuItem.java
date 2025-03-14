package com.example.kiosk.challv1;

import java.util.HashMap;
import java.util.Map;

public class MenuItem {
    // 버거 이름 가격 설명 선언
    // int id int quantity 가 있는게 베스트
    private String burgerName;
    private int burgerPrice;
    private String burgerDescription;

    public MenuItem (String burgerName,int burgerPrice,String burgerDescription) {
        this.burgerName = burgerName;
        this.burgerPrice = burgerPrice;
        this.burgerDescription = burgerDescription;
    }

    public String toString() {
        return burgerName+" "+burgerPrice+"원"+"\n"+burgerDescription;
    }

    // 버거 이름 버거 가격 버거 설명 각각 따로 호출하는 메서드 작성
    public String getBurgerName(){
        return burgerName;
    }

    public int getBurgerPrice(){
        return burgerPrice;
    }

    public String getBurgerDescription(){
        return burgerDescription;
    }
}