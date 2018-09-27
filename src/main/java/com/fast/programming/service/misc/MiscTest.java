package com.fast.programming.service.misc;

/**
 * @author bowen.yan
 * @date 2018-08-08
 */
public class MiscTest {
    public static void main(String args[]) {
        int max = 10000;
//        for (int i = 0; i <= max; i++) {
//            System.out.println(i * i);
//        }
        squareAndPrint(1, max);
    }

    public static void squareAndPrint(int n, int max) {
        System.out.println(n * n);
        if (max > n) {
            squareAndPrint(n + 1, max);
        }
    }
}
