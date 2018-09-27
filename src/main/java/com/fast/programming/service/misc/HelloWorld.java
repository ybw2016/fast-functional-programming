package com.fast.programming.service.misc;

import java.util.Arrays;
import java.util.List;

/**
 * @author bowen.yan
 * @since 2016-09-16
 */
public class HelloWorld {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello ", "World", "!");
        words.forEach(word -> System.out.print(word));
    }
}