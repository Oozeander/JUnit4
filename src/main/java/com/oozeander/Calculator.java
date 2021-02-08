package com.oozeander;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int[] addEach(int[] array, int a) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i] + a;
        return newArray;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public boolean isEven(int a) {
        return a % 2 == 0;
    }

    public void addTen(int a) {
        a += 10;
    }
}