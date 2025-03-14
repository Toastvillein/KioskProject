package com.example.kiosk.challv2;


import java.util.HashMap;
import java.util.Map;

public class ShoppingCart<K,N> {
    //장바구니 필드선언 Map
    Map<MenuItem ,Integer> cartMap = new HashMap<>();

    // 메뉴 이름과 값을 Map에 저장하는 메서드
    public void addCart(MenuItem menu, Integer quantity){
        cartMap.put(menu,cartMap.getOrDefault(menu, 0)+1);
    }

    // Map 값을 호출하는 메서드
    public void showCart(){
        cartMap.forEach((key ,value) ->{
            System.out.println(key.getBurgerName()+" "+value+"개");
        });
    }


    // Map 값을 초기화하는 메서드
    public void clearCart(){
        cartMap.clear();
    }

    // 총 금액 메서드
    public int fullPrice(){
        int totalPrice = 0;
        for (Map.Entry<MenuItem, Integer> entry : cartMap.entrySet()) {
            MenuItem menuItem = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += menuItem.getBurgerPrice().intValue()*quantity;
        }
        //System.out.print(totalPrice+"원");
        return totalPrice;
    }

    // 특정 메뉴를 빼는 stream 메서드
    public void removeCart(Map<MenuItem,Integer> cartMap, String removeKey){
        cartMap.keySet().stream()
                .filter(key -> key.equals(removeKey))
                .findFirst()
                .ifPresent(key->cartMap.remove(key));
    }
}
