package com.fast.programming.service.groupby;

import com.fast.programming.model.Trade;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

/**
 * 将一个集合分成两个部分
 *
 * @author bowen.yan
 * @since 2016-09-16
 */
public class PartitionBy extends FeatureBase {
    @Override
    protected String getComment() {
        return "集合处理 -> 将一个集合切割成两个部分（满足条件的和不满足条件的）";
    }

    @Override
    protected void runOld() {
        List<Trade> trades = TradeService.getTrades();
        List<Trade> lessThan1W = new ArrayList<>();
        List<Trade> moreThan1W = new ArrayList<>();
        for (Trade trade : trades) {
            if (trade.getDealBalance() <= 10000) {
                lessThan1W.add(trade);
            } else {
                moreThan1W.add(trade);
            }
        }
        printTrades("小散", lessThan1W);
        printTrades("VIP客户", moreThan1W);
    }

    @Override
    protected void runNew() {
        Map<Boolean, List<Trade>> tradeMap = TradeService.getTrades()
                .stream()
                .collect(partitioningBy(trade -> trade.getDealBalance() <= 10000));
        List<Trade> lessThan1W = tradeMap.get(Boolean.TRUE);
        List<Trade> moreThan1W = tradeMap.get(Boolean.FALSE);
        printTrades("小散", lessThan1W);
        printTrades("VIP客户", moreThan1W);
    }

    private void printTrades(String category, List<Trade> trades) {
        System.out.println("股民资产类别: " + category);
        System.out.println("交易信息如下");
        trades.forEach(trade -> System.out.println(trade));
        System.out.println();
    }
}
