package com.fast.programming.service.example.search;

import com.fast.programming.enums.ExchangeType;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

import java.util.List;
import java.util.Optional;

/**
 * @author bowen.yan
 * @date 2018-08-08
 */
public class NullOptional extends FeatureBase {
    @Override
    protected String getComment() {
        return "空值判断";
    }

    @Override
    protected void runOld() {
        List<ExchangeType> exchangeTypes = TradeService.getExchangeTypes();
        if (exchangeTypes != null) {
            System.out.println(exchangeTypes);
        }
    }

    @Override
    protected void runNew() {
        Optional<List<ExchangeType>> data = Optional.ofNullable(TradeService.getExchangeTypes());
        data.ifPresent(exchangeTypes -> System.out.println(exchangeTypes));
    }
}
