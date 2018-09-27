package com.fast.programming.service.misc;

import com.fast.programming.service.FeatureBase;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class Basis extends FeatureBase {
    @Override
    protected String getComment() {
        return "常用api";
    }

    @Override
    protected void runOld() {

    }

    @Override
    protected void runNew() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Iterator<Integer> iterator = list.iterator();
        Integer sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        list.stream()
                .filter(data -> data.intValue() < 6)
                .map(data -> new BigDecimal(data))
                .reduce(BigDecimal.ZERO, (current, next) -> current.add(next)).intValue();

        list.stream().reduce(0, (current, next) -> current + next);
    }

    private void calculate() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        BigDecimal sum = list.stream()
                .filter(data -> data.intValue() < 6)
                .map(data -> new BigDecimal(data))
                .reduce(BigDecimal.ZERO, (current, next) -> current.add(next));
        println("sum = " + sum);
    }

    public static void main() {
        Date startTime = new Date();
        long sumOld = 0;
        for (int i = 1; i <= 1000000; i++) {
            sumOld += i;
        }
        Date endTime = new Date();
        printTimeSeconds("old", startTime, endTime);
    }

    private static void printTimeSeconds(String title, Date startTime, Date endTime) {
        System.out.println(title + " --> 耗时: " + (startTime.getTime() - endTime.getTime()) + "s");
    }
}