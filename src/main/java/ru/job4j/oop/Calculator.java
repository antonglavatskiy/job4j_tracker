package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        int resultSum = Calculator.sum(15);
        System.out.println(resultSum);
        int resultMinus = Calculator.minus(13);
        System.out.println(resultMinus);
        Calculator calculator = new Calculator();
        int resultMultiply = calculator.multiply(8);
        System.out.println(resultMultiply);
        int resultDivide = calculator.divide(50);
        System.out.println(resultDivide);
        int resultAll = calculator.sumAllOperation(100);
        System.out.println(resultAll);
    }
}
