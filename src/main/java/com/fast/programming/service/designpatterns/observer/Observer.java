package com.fast.programming.service.designpatterns.observer;

import com.fast.programming.enums.OperationType;

/**
 * @author bowen.yan
 * @since 2016-09-18
 */
public interface Observer {
    public void update(OperationType operationType);
}
