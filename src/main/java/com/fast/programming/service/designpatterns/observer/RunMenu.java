package com.fast.programming.service.designpatterns.observer;

import com.fast.programming.enums.OperationType;

/**
 * @author bowen.yan
 * @since 2016-09-18
 */
public class RunMenu implements Observer, Printer {
    @Override
    public void update(OperationType operationType) {
        if (OperationType.Build.equals(operationType)) {
            println("enable【Stop】button!");
        } else {
            println("enable all buttons under【Run】Menu!");
        }
    }
}
