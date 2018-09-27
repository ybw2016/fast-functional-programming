package com.fast.programming.service.example.search;

import com.fast.programming.model.Trade;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

import java.util.List;

/**
 * @author bowen.yan
 * @date 2018-08-08
 */
public class IfElseCheck extends FeatureBase {
    @Override
    protected String getComment() {
        return "判断取值 -> 优雅简洁地处理if else";
    }

    @Override
    protected void runOld() {
        List<Trade> trades = TradeService.getTrades();

        Trade findTrade = null;
        for (Trade trade : trades) {
            if (trade.getUser().getUserName().equals("张三")) {
                findTrade = trade;
                break;
            }
        }
        if (findTrade == null) {
            findTrade = trades.get(0);
        }
        System.out.println(findTrade);
    }

    @Override
    protected void runNew() {
        List<Trade> trades = TradeService.getTrades();
        Trade findTrade = trades.stream()
                .filter(trade -> trade.getUser().getUserName().equals("张三"))
                .findFirst()
                .orElseGet(() -> trades.get(0));
        System.out.println(findTrade);
    }
}
