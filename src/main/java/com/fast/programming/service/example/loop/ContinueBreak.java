package com.fast.programming.service.example.loop;

import com.fast.programming.model.Trade;
import com.fast.programming.model.User;
import com.fast.programming.service.FeatureBase;
import com.fast.programming.service.TradeService;

import java.util.List;

/**
 * @author bowen.yan
 * @date 2018-08-08
 */
public class ContinueBreak extends FeatureBase {
    @Override
    protected String getComment() {
        return "函数式编程的缺点 -> 循环中的break和continue不支持!";
    }

    @Override
    protected void runOld() {
        List<Trade> trades = TradeService.getTrades();
        for (Trade trade : trades) {
            if (User.MA_HUA_TENG.equals(trade.getUser())) {
                //continue; // continue -> Filter not equals
                break; // break -> Throw Exception
            }
            System.out.println(trade);
        }
    }

    @Override
    protected void runNew() {
        List<Trade> trades = TradeService.getTrades();
        //continueByFilter(trades);
        breakByThrow(trades);
    }

    private void continueByFilter(List<Trade> trades) {
        trades.stream()
                .filter(trade -> !User.MA_HUA_TENG.equals(trade.getUser()))
                .forEach(trade -> System.out.println(trade));
    }

    private void breakByThrow(List<Trade> trades) {
//        try {
//            trades.forEach((Trade trade) -> new Consumer<Trade>() {
//                @Override
//                public void accept(Trade trade) {
//                    if (User.MA_HUA_TENG.equals(trade.getUser())) {
//                        throw new RuntimeException("退出循环");
//                    }
//                    System.out.println(trade);
//                }
//            }.accept(trade));
//        } catch (Exception ex) {
//            System.out.println("循环时有异常！");
//        }

        try {
            trades.forEach(trade -> {
                if (User.MA_HUA_TENG.equals(trade.getUser())) {
                    throw new RuntimeException("退出循环");
                }
                System.out.println(trade);
            });
        } catch (Exception ex) {
            System.out.println("循环时有异常！");
        }
    }
}
