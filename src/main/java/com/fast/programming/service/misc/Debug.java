package com.fast.programming.service.misc;

import com.fast.programming.enums.ExchangeType;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

import java.util.stream.Collectors;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class Debug extends FeatureBase {
    @Override
    protected String getComment() {
        return "调试功能 -> 打印日志";
    }

    @Override
    protected void runOld() {
    }

    @Override
    protected void runNew() {
        TradeService.getTrades()
                .stream()
                .filter(trade -> ExchangeType.YH.equals(trade.getSecurity().getExchangeType()))
                .peek(trade -> println("print from peek() --> ", trade))
                .filter(trade -> trade.getDealAmount() > 100)
                .collect(Collectors.toList());
    }
}
