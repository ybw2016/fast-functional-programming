package com.fast.programming.service.designpatterns.observer;

import com.fast.programming.enums.OperationType;

/**
 * @author bowen.yan
 * @since 2016-09-18
 */
public class BuildMenu implements Observer, Printer {
    @Override
    public void update(OperationType operationType) {
        if (OperationType.Build.equals(operationType)) {
            println("disable【Build-Make Project】button!");
            println("disable【Rebuild Project】button!");
            println("enable【Generate Ant Build】button!");
        } else {
            println("enable all buttons under【Build】Menu!");
        }
    }
}
