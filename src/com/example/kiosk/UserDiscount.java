package com.example.kiosk;

public enum UserDiscount {
    MERITORIOUS(0.1),SOLDIER(0.05),STUDENT(0.03);

    private double discount;

    private UserDiscount(double discount){
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }

    public double meritorious(int a){
        return a*MERITORIOUS.getDiscount();
    }

    public double soldier(int a){
        return a* SOLDIER.getDiscount();
    }

    public double student(int a){
        return a* STUDENT.getDiscount();
    }
}
