package com.fast.programming.service.misc;

import com.fast.programming.service.FeatureBase;

import java.util.stream.Stream;

/**
 * @author bowen.yan
 * @date 2018-05-11
 */
public class IteratorStream extends FeatureBase {
    private static final String USER_NAMES = "zhangsan,lisi,wangwu,zhaoliu";

    @Override
    protected String getComment() {
        return "无限流";
    }

    @Override
    protected void runOld() {

    }

    @Override
    protected void runNew() {
        Adder adder = new Adder();
        Stream.iterate(USER_NAMES, userName -> {
            adder.increment();
            return userName;
        })
                .limit(20)
                .filter(userName -> adder.complete())
                .forEach(System.out::println);

        Stream.iterate(1, item -> item + 1)
                .limit(10)
                .forEach(System.out::println);

        Stream.generate(Math::random).findFirst().ifPresent(System.out::println);
    }

    class Adder {
        private int number;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public void increment() {
            number++;
        }

        public boolean complete() {
            return number <= 10;
        }
    }
}
