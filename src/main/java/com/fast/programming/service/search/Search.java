package com.fast.programming.service.search;

import com.fast.programming.model.Trade;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

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
//int index =0;
//index ++;
//if(index ==0){
//    continue;
//}
    }

    @Override
    protected void runNew() {
        printTitle("跳过第m=1条记录, 查找n=3条记录");
        TradeService.getTrades()
                .stream()
                .skip(1)
                .limit(3)
                .collect(Collectors.toList())
                .forEach(trade -> println(trade));
        println();

        printTitle("第1条记录");
        Trade tradeFirst = TradeService.getTrades()
                .stream()
                .findFirst()
                .get();
        println(tradeFirst);
        println();

        printTitle("第任意条记录");
        Trade tradeAny = TradeService.getTrades()
                .stream()
                .findAny()
                .get();
        println(tradeAny);
        println();

        printTitle("第任意条记录(并行)");
        Trade tradeAnyParallel = TradeService.getTrades()
                .parallelStream()
                .findAny()
                .get();
        println(tradeAnyParallel);
        println();
    }
}
