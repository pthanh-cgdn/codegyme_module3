package com.codegyme.discount_cal.services;

public class Calculator {

    public int calDiscount(int price, double discount) {
        return (int) (price - (price*discount));
    }
}
