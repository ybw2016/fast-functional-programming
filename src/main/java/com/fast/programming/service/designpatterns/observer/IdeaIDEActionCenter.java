package com.fast.programming.service.designpatterns.observer;

import com.fast.programming.enums.OperationType;
import com.fast.programming.service.FeatureBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bowen.yan
 * @since 2016-09-18
 */
public class IdeaIDEActionCenter extends FeatureBase {
    private List<Observer> observers;

    private void initObservers() {
        observers = new ArrayList<>();
    }

    private void runCommand(OperationType operationType) {
        for (Observer observer : observers) {
            observer.update(operationType);
        }
    }

    private void runCommandFunctional(OperationType operationType) {
        observers.forEach(observer -> observer.update(operationType));
    }

    @Override
    protected void runOld() {
        // 初始化观察者
        initObservers();
        observers.add(new BuildMenu());
        observers.add(new RunMenu());

        // 执行Build操作
        runCommand(OperationType.Build);
    }

    @Override
    protected void runNew() {
        // 初始化观察者
        initObservers();

        // Build Menu
        observers.add(operationType -> {
            if (OperationType.Build.equals(operationType)) {
                println("disable【Build-Make Project】button!");
                println("disable【Rebuild Project】button!");
                println("enable【Generate Ant Build】button!");
            } else {
                println("enable all buttons under【Build】Menu!");
            }
        });

        // Run Menu
        observers.add(operationType -> {
            if (OperationType.Build.equals(operationType)) {
                println("enable【Stop】button!");
            } else {
                println("enable all buttons under【Run】Menu!");
            }
        });

        runCommandFunctional(OperationType.Build);
    }
}
