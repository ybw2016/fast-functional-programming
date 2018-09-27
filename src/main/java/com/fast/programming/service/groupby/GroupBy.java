package com.fast.programming.service.groupby;

import com.fast.programming.enums.AreaEnum;
import com.fast.programming.model.Trade;
import com.fast.programming.model.User;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TimesCounter;
import com.fast.programming.service.TradeService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toSet;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class GroupBy extends FeatureBase {
    @Override
    protected String getComment() {
        return "集合处理 -> 对列表进行分组、汇总，相当于sql语句中的 group by";
    }

    @Override
    protected void runOld() {
        Map<AreaEnum, Set<User>> investorMap = new HashMap<>();
        for (Trade trade : TradeService.getTrades()) {
            Set<User> users = investorMap.get(trade.getUser().getAreaEnum());
            if (users == null) {
                users = new HashSet<>();
                investorMap.put(trade.getUser().getAreaEnum(), users);
            }
            users.add(trade.getUser());
        }
        // 统计每个区域的股民信息
        for (Map.Entry<AreaEnum, Set<User>> entry : investorMap.entrySet()) {
            println("区域", entry.getKey());
            println("股民信息如下");
            for (User user : entry.getValue()) {
                println(user);
            }
        }
    }

    @Override
    protected void runNew() {
        TradeService.getTrades()
                .stream()
                .collect(groupingBy(trade -> trade.getUser().getAreaEnum(),
                        mapping(trade -> trade.getUser(), toSet())))
                .forEach((areaEnum, users) -> {
                    // 统计每个区域的股民信息
                    println("区域", areaEnum);
                    println("股民信息如下");
                    users.forEach(user -> println(user));
                });
    }

    @Override
    protected void runMisc() {
        totalInvestBalance();
    }

    /**
     * 收集到指定容器中(线程安全的Hashtable)
     */
    private void safetyHashtable() {
        TradeService.getTrades()
                .stream()
                .filter(trade -> trade.getDealAmount() >= 200)
                .collect(groupingBy(trade -> trade.getUser().getAreaEnum(),
                        () -> new Hashtable<>(),/* 换成线程安全的哈希表 */
                        mapping(trade -> trade.getUser(), toSet())))
                .forEach((areaEnum, users) -> {
                    println("区域", areaEnum);
                    println("股民信息如下");
                    users.forEach(user -> println(user));
                });
    }

    /**
     * 投资次数最多的股民信息(临时类)
     */
    private void tradeTimesMost() {
        printTitle("投资次数比较");
        List<TimesCounter> timesCounters = new ArrayList<>();
        TradeService.getTrades()
                .stream()
                .collect(groupingBy(trade -> trade.getUser().getUserName(),
                        counting()))
                .forEach((userName, count) -> {
                    timesCounters.add(new TimesCounter(userName, count));
                });
        TimesCounter timesCounter = timesCounters
                .stream()
                .collect(maxBy(Comparator.comparing(t -> t.getCount())))
                .get();
        println(String.format("交易次数最多的股民信息 --> 股民:%s, 交易次数:%s", timesCounter.getKey(), timesCounter.getCount()));
    }

    /**
     * 投资次数最多的股民信息(无临时类)
     * select bizDate, count(*) from stock.cfo_stock_tclose
     * group by bizDate
     * order by count(*) desc
     * limit 1;
     */
    private void tradeTimesMostNew() {
        printTitle("投资次数比较New");
        Map.Entry<String, Long> counter = TradeService.getTrades()
                .stream()
                .collect(groupingBy(trade -> trade.getUser().getUserName(), counting())) /* MySQL 可以 limit 1直接返回二次排序的结果*/
                .entrySet()
                .stream() /* 第二次使用流进行计算 */
                .collect(maxBy(Comparator.comparing(t -> t.getValue())))
                .get();
        println(String.format("交易次数最多的股民信息 --> 股民:%s, 交易次数:%s", counter.getKey(), counter.getValue()));
    }

    /**
     * 每个股民金额最大的一笔投资( 重要 )
     */
    private void investMostBalancePerInvestor() {
        printTitle("每个股民金额最大的一笔投资");
        Comparator<Trade> maxByBalance = Comparator.comparing(Trade::getDealBalance);

        TradeService.getTrades()
                .stream()
                .collect(groupingBy(trade -> trade.getUser().getUserName(),
                        reducing(BinaryOperator.maxBy(maxByBalance)) /* 注意: reducing()显式声明如何比较 */
                ))
                .forEach((investorName, balance) -> {
                    println(String.format("每个股民金额最大的一笔投资 --> 股民:%s, 投资金额(元):%s", investorName, balance));
                });
    }

    /**
     * 每个股民投资的总金额
     */
    private void totalInvestBalance() {
        printTitle("每个股民投资的总金额");
        TradeService.getTrades()
                .stream()
                .collect(groupingBy(trade -> trade.getUser().getUserName(),
                        summingDouble(trade -> trade.getDealBalance())
                ))
                .forEach((investorName, totalInvestBalance) -> {
                    println(investorName + ": " + totalInvestBalance);
                });
    }
}
