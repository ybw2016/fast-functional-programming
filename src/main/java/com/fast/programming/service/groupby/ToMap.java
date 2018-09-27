package com.fast.programming.service.groupby;

import com.fast.programming.enums.ExchangeType;
import com.fast.programming.model.Trade;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 统计每个区域的股民信息
 *
 * @author bowen.yan
 * @since 2016-09-15
 */
public class ToMap extends FeatureBase {
    @Override
    protected String getComment() {
        return "集合处理 -> 将列表变成哈希表";
    }

    @Override
    protected void runOld() {
        printTitle("绑定【交易所枚举】前");
        List<Trade> trades = TradeService.getTradesOfNoExchType();
        for (Trade trade : trades) {
            println(trade);
        }

        Map<String, ExchangeType> exchTypeMap = new HashMap<>();
        for (ExchangeType exchType : TradeService.getExchangeTypes()) {
            exchTypeMap.put(exchType.getAlias(), exchType);
        }
        printTitle("绑定【交易所枚举】后");
        for (Trade trade : trades) {
            trade.getSecurity().setExchangeType(exchTypeMap.get(trade.getSecurity().getExchTypeStr()));
        }
    }

    @Override
    protected void runNew() {
        printTitle("绑定【交易所枚举】前");
        List<Trade> trades = TradeService.getTradesOfNoExchType();
        trades.forEach(trade -> println(trade));

        Map<String, ExchangeType> exchTypeMap = TradeService.getExchangeTypes()
                .stream()
                .collect(Collectors.toMap(
                        exchType -> exchType.getAlias(),
                        exchType -> exchType)
                );

        trades.forEach(trade -> {
            // 绑定前：exchangeType=null
            // 绑定后：exchangeType=ExchangeType{value='1', name='上海'}
            trade.getSecurity().setExchangeType(exchTypeMap.get(trade.getSecurity().getExchTypeStr()));
        });
        printTitle("绑定【交易所枚举】后");
        trades.forEach(trade -> println(trade));
    }
}
