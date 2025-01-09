package com.group.libraryapp.dto.response;

public class CalculatorResponse {
    private int add;
    private int minus;
    private int multiply;

    public int getAdd() {
        return add;
    }

    public int getMinus() {
        return minus;
    }

    public int getMultiply() {
        return multiply;
    }

    public CalculatorResponse(int add, int minus, int multiply) {
        this.add = add;
        this.minus = minus;
        this.multiply = multiply;
    }
}
