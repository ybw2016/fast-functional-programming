package com.fast.programming;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author bw
 * @since 2020-12-11
 */
public class MiscTest {
    public static void main(String[] args) {
        testFunction();
    }

    private static void testFunction() {
        Function<String, String> nameGetter1 = name -> name + "Func1";
        Function<String, String> nameGetter2 = name -> name + "Func2";

        // 2020Func1Func2
        System.out.println(nameGetter1.andThen(nameGetter2).apply("2020"));
        // 2020Func2Func1
        System.out.println(nameGetter1.compose(nameGetter2).apply("2020"));

        Objects.requireNonNull(null, "参数不能为空");
    }
}
