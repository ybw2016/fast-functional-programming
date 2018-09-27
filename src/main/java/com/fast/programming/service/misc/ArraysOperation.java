package com.fast.programming.service.misc;

import com.fast.programming.model.User;
import com.fast.programming.service.FeatureBase;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class ArraysOperation extends FeatureBase {
    @Override
    protected String getComment() {
        return "汇集多个集合成一个流 -> Stream.of() & Stream().flatMap()";
    }

    @Override
    protected void runOld() {
    }

    @Override
    protected void runNew() {
        printTitle("打印来自BAT公司的投资者姓名");
        Stream.of(User.LI_YAN_HONG, User.MA_YUN, User.MA_HUA_TENG, User.LEI_JUN, User.LIU_QINAG_DONG)
                .filter(User::isFromBeijing)
                .filter(User::isBAT)
                .map(User::getUserName)
                .forEach(this::println);

        // List<T> -> Stream<T>   .stream()
        // List<List<T>> -> Stream<T>   Stream.of(...).flatMap() -> Stream<T>
        printTitle("打印来自BAT公司的投资者姓名2");
        Stream.of(Arrays.asList(User.LI_YAN_HONG, User.MA_YUN), Arrays.asList(User.MA_HUA_TENG, User.LEI_JUN, User.LIU_QINAG_DONG))
                .flatMap(users -> users.stream()) /* flatMap:合并流。 每一个元素都是一个集合, 因此用users */
                .filter(User::isFromBeijing)
                .filter(User::isBAT)
                .map(User::getUserName)
                .forEach(this::println);
    }

    @Override
    protected void runMisc() {
        int end = 10000000;
        int[] arr = new int[end];
        for (int i = 1; i <= end; i++) {
            arr[i - 1] = i;
        }

        Date startTime = new Date();
        long rawSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            rawSum += arr[i];
        }
        Date endTime = new Date();
        long rawSeconds = endTime.getTime() - startTime.getTime();

        long paralSum = IntStream.range(1, end).parallel().sum();
        Date paramEndDate = new Date();
        long paralSeconds = paramEndDate.getTime() - endTime.getTime();

        println("raw().sum() -> " + rawSum);
        println("parallel().sum() -> " + paralSum);
        println("raw().sum() millSeconds -> " + rawSeconds + ", parallel().sum() millSeconds -> " + paralSeconds);
    }
}
