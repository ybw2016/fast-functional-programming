package com.fast.programming.service.groupby;

import com.fast.programming.model.Trade;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class MinMaxAvgSum extends FeatureBase {
    @Override
    protected String getComment() {
        return "获取集合的最大值、最小值";
    }

    @Override
    protected void runOld() {
        List<Trade> trades = TradeService.getTrades();

        // 升序排序
        Collections.sort(trades, new Comparator<Trade>() {
            @Override
            public int compare(Trade o1, Trade o2) {
                // 按股票成交数量排序
                return Double.compare(o1.getDealAmount(), o2.getDealAmount());
            }
        });

        double min = trades.get(0).getDealAmount();
        double max = trades.get(trades.size() - 1).getDealAmount();
        double sum = 0;
        for (Trade trade : trades) {
            sum += trade.getDealAmount();
        }
        double avg = new BigDecimal(sum / trades.size()).doubleValue();

        println("股票成交数量分析");
        println(String.format("股票成交数量: Max:%s, Min:%f, Average:%f, Sum:%f",
                max, min, avg, sum));
    }

    @Override
    protected void runNew() {
        println("股票成交数量分析");
        DoubleSummaryStatistics statistics = TradeService.getTrades()
                .stream()
                .mapToDouble(trade -> trade.getDealAmount())
                .summaryStatistics();

        println(String.format("股票成交数量: Max:%s, Min:%f, Average:%f, Sum:%f",
                statistics.getMax(),
                statistics.getMin(),
                statistics.getAverage(),
                statistics.getSum()
        ));
    }
}
