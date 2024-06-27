package com.codegyme.ss9.services.impl;

import com.codegyme.ss9.services.ICalculatorService;

public class CalculatorService implements ICalculatorService {
    @Override
    public int sum(int a, int b) {
        return a+b;
    }
}
