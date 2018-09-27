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
public class Search extends FeatureBase {
    @Override
    protected String getComment() {
        return "获取集合 -> skip() && limit() && findFirst()";
    }

    @Override
    protected void runOld() {
        List<Trade> trades = TradeService.getTrades();
        List<Trade> searchTrades = new ArrayList<>();

        int skip = 2;
        int limit = 3;
        for (int i = 0; i < trades.size(); i++) {
            if ((i + 1) > skip) {
                searchTrades.add(trades.get(i));
            }
            if (((i + 1) - skip) == limit) {
                break;
            }
        }
        searchTrades.forEach(System.out::println);
    }

    @Override
    protected void runNew() {
        printTitle("跳过前m=2条记录, 查找n=3条记录");
        TradeService.getTrades()
                .stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList())
                .forEach(trade -> println(trade));
        println();
    }
}
