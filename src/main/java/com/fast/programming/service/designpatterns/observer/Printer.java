package com.fast.programming.service.designpatterns.observer;

/**
 * @author bowen.yan
 * @since 2016-09-18
 */
public interface Printer {
    public default void println(String message) {
        System.out.println(message );
    }
}
