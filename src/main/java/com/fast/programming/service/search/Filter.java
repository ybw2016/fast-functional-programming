package com.fast.programming.service.search;

import com.fast.programming.model.Trade;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class Filter extends FeatureBase {
    @Override
    protected String getComment() {
        return "过滤功能 -> 相当于if else判断";
    }

    @Override
    protected void runOld() {
        printTitle("distinct");
        List<Trade> trades = TradeService.getTrades();
        List<String> userNames = new ArrayList<>();
        for (Trade trade : trades) {
            // 去重
            if (!userNames.contains(trade.getUser().getUserName())) {
                // 添加到集合
                userNames.add(trade.getUser().getUserName());// 筛选人名
            }
        }
        // 打印人名
        for (String userName : userNames) {
            println(userName);
        }
    }

    @Override
    protected void runNew() {
        // 方法1
        printTitle("distinct 1");
        TradeService.getTrades()
                .stream()
                .map(trade -> trade.getUser().getUserName())// 筛选人名
                .distinct() /* 过滤重复 */  //去重
                .forEach(userName -> println(userName));

        // 方法2
        printTitle("distinct 2");
        TradeService.getTrades()
                .stream()
                .map(trade -> trade.getUser().getUserName())
                .collect(Collectors.toSet()) /* 过滤重复 */
                .forEach(userName -> println(userName));
    }

    @Override
    protected void runMisc() {
        printTitle("Misc groupby");
        TradeService.getTrades()
                .stream()
                .filter(trade -> trade.getDealAmount() >= 5000)
                .collect(Collectors.groupingBy(trade -> trade.getUser()))
                .forEach((user, trades) -> {
                    println("股民: " + user);
                    println("T日炒股信息如下: ");
                    trades.forEach(trade -> println(trade));
                });
    }
}
