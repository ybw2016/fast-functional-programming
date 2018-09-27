package com.fast.programming.service.orderby;

import com.fast.programming.model.Trade;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 先按成交数量、再按成交金额排序(由大到小排序)
 *
 * @author bowen.yan
 * @since 2016-09-15
 */
public class OrderBy extends FeatureBase {
    @Override
    protected String getComment() {
        return "排序 -> 升序、降序";
    }

    @Override
    protected void runOld() {
        List<Trade> trades = TradeService.getTrades();

        // 升序排序
        Collections.sort(trades, new Comparator<Trade>() { /* 会改变trades的顺序 */
            @Override
            public int compare(Trade o1, Trade o2) {
                // 按股票成交数量排序
                int result = Double.compare(o2.getDealAmount(), o1.getDealAmount());
                if (result == 0) {
                    return Double.compare(o2.getDealBalance(), o1.getDealBalance());
                }
                return result;
            }
        });

        for (Trade trade : trades) {
            System.out.println(trade);
        }
    }

    @Override
    protected void runNew() {
//        TradeService.getTrades()
//                .stream()
//                .sorted((trade1, trade2) -> {
//                    // 按股票成交数量排序
//                    int result = Double.compare(trade2.getDealAmount(), trade1.getDealAmount());
//                    if (result == 0) {
//                        return Double.compare(trade2.getDealBalance(), trade1.getDealBalance());
//                    }
//                    return result;
//                })
//                .collect(Collectors.toList())
//                .forEach(trade -> System.out.println(trade));

        TradeService.getTrades().stream()
                //.sorted((t1, t2) -> Double.valueOf(t2.getDealAmount()).compareTo(Double.valueOf(t1.getDealAmount())))
                .sorted((t1, t2) -> Double.compare(t1.getDealAmount(), t2.getDealAmount()))
                .collect(Collectors.toList());

        // 流式排序不改变集合顺序
        /*
        TradeService.getTrades()
                .stream()
                .sorted(Comparator.comparing((Trade trade) -> trade.getDealAmount()).reversed()
                        .thenComparing((Trade trade) -> trade.getDealBalance()).reversed())
                .collect(Collectors.toList())
                .forEach(trade -> System.out.println(trade));
                */
    }
}
