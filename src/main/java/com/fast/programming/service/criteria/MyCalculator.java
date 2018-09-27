package com.fast.programming.service.criteria;

/**
 * Lambda表达式 & 匿名函数.
 *
 * @author bowen.yan
 * @since 2016-09-23
 */
public class MyCalculator {
    private double number1;
    private double number2;

    public MyCalculator(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public void startCalc(Calculator calculator) {
        double result = calculator.calculate(number1, number2);
        System.out.println(result);
    }

    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator(2, 8);
        // 加
        Calculator addCalculator = (double number1, double number2) -> {
            return number1 + number2;
        };
        myCalculator.startCalc(addCalculator);

        // 减
        Calculator subCalculator = (number1, number2) -> {
            return number1 - number2;
        };
        myCalculator.startCalc(subCalculator);

        // 乘
        Calculator multiCalculator = (number1, number2) -> number1 * number2;
        myCalculator.startCalc(multiCalculator);

        // 除
        myCalculator.startCalc((number1, number2) -> number1 / number2);
    }
}
