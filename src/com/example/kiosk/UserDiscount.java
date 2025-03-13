package com.example.kiosk;

public enum UserDiscount {
    MERITORIOUS(0.1),SOLDIER(0.05),STUDENT(0.03);

    private double discount;

    private UserDiscount(double discount){
        this.discount = discount;
    }

    public double doDicount(int a){
        return a*discount;
    }

}
