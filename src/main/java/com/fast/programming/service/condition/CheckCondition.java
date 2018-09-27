package com.fast.programming.service.condition;

import com.fast.programming.enums.AreaEnum;
import com.fast.programming.enums.StockType;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

/**
 * 统计每个区域的股民信息
 *
 * @author bowen.yan
 * @since 2016-09-15
 */
public class CheckCondition extends FeatureBase {
    @Override
    protected String getComment() {
        return "逻辑判断 -> allMatch() && noneMatch() && anyMatch()";
    }

    @Override
    protected void runOld() {

    }

    @Override
    protected void runNew() {
        printTitle("判断: 所有投资者都不是VIP");
        // VIP 大客户单笔成交在200手+
        boolean isNotVipInvestor = TradeService.getTrades()
                .stream()
                .allMatch(trade -> trade.getDealAmount() < 20000);
        println("所有投资者都不是VIP", isNotVipInvestor);

        printTitle("判断: 所有客户都没有买回购");
        boolean noRepo = TradeService.getTrades()
                .stream()
                .noneMatch(trade -> StockType.REPO.equals(trade.getSecurity().getStockType()));
        println("所有客户都没有买回购", noRepo);

        printTitle("判断: 有杭州客户");
        boolean fromHZ = TradeService.getTrades()
                .stream()
                .anyMatch(trade -> !AreaEnum.HZ.equals(trade.getUser().getAreaEnum()));
        println("有杭州客户", fromHZ);

    }
}
