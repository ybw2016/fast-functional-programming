package com.fast.programming.service;

import com.fast.programming.enums.EntrustBs;
import com.fast.programming.enums.ExchangeType;
import com.fast.programming.enums.StockType;
import com.fast.programming.model.Security;
import com.fast.programming.model.Trade;
import com.fast.programming.model.User;
import com.fast.programming.utils.DateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class TradeService {
    public static List<Trade> getTrades() {
        List<Trade> trades = new ArrayList<Trade>();
        trades.add(new Trade(User.LI_YAN_HONG, Security.S_002502, EntrustBs.BUY, 600, 28.52, DateUtil.parse("2016-09-13 10:22:39")));
        trades.add(new Trade(User.LI_YAN_HONG, Security.S_002157, EntrustBs.BUY, 300, 7.6, DateUtil.parse("2016-09-13 14:20:18")));

        trades.add(new Trade(User.MA_YUN, Security.S_000725, EntrustBs.BUY, 12000, 6.0, DateUtil.parse("2016-09-13 10:20:18")));
        trades.add(new Trade(User.MA_YUN, Security.S_002157, EntrustBs.BUY, 200, 7.7, DateUtil.parse("2016-09-13 14:20:18")));
        trades.add(new Trade(User.MA_YUN, Security.S_150005, EntrustBs.BUY, 200, 101.2, DateUtil.parse("2016-09-13 09:10:10")));
        trades.add(new Trade(User.MA_YUN, Security.S_150005, EntrustBs.SELL, 150, 103.8, DateUtil.parse("2016-09-13 09:20:10")));
        trades.add(new Trade(User.MA_YUN, Security.S_601216, EntrustBs.SELL, 5000, 5.0, DateUtil.parse("2016-09-13 10:22:39")));
        trades.add(new Trade(User.MA_YUN, Security.S_150130, EntrustBs.BUY, 1000, 1.22, DateUtil.parse("2016-09-13 13:10:39")));
        trades.add(new Trade(User.MA_YUN, Security.S_150131, EntrustBs.BUY, 1000, 2.06, DateUtil.parse("2016-09-13 10:22:39")));
        trades.add(new Trade(User.MA_YUN, Security.S_002502, EntrustBs.BUY, 100, 28.52, DateUtil.parse("2016-09-13 10:22:39")));

        trades.add(new Trade(User.MA_HUA_TENG, Security.S_601216, EntrustBs.SELL, 5000, 5.0, DateUtil.parse("2016-09-13 10:22:39")));
        trades.add(new Trade(User.MA_HUA_TENG, Security.S_601216, EntrustBs.SELL, 2000, 5.0, DateUtil.parse("2016-09-13 10:22:39")));

        trades.add(new Trade(User.LEI_JUN, Security.S_601216, EntrustBs.SELL, 5000, 5.0, DateUtil.parse("2016-09-13 10:22:39")));
        trades.add(new Trade(User.LIU_QINAG_DONG, Security.S_601216, EntrustBs.SELL, 5000, 6.0, DateUtil.parse("2016-09-13 10:22:39")));

        return trades;
    }

    public static List<Trade> getTradesOfNoExchType() {
        List<Trade> trades = new ArrayList<Trade>();
        trades.add(new Trade(User.ZHOU_HONG_YI, Security.S_600000, EntrustBs.BUY, 600, 20.52, DateUtil.parse("2016-09-13 10:22:39")));
        trades.add(new Trade(User.ZHOU_HONG_YI, Security.S_000002, EntrustBs.BUY, 300, 9.6, DateUtil.parse("2016-09-13 14:20:18")));

        return trades;
    }

    public static List<ExchangeType> getExchangeTypes() {
        return Arrays.asList(
                ExchangeType.SH,
                ExchangeType.SZ,
                ExchangeType.YH,
                ExchangeType.CW,
                ExchangeType.HK,
                ExchangeType.MG
        );
    }

    public static List<StockType> getStockTypes() {
        return Arrays.asList(
                StockType.STOCK,
                StockType.FUND,
                StockType.REPO,
                StockType.BOND,
                StockType.LOF_FUND,
                StockType.ETF_FUND,
                StockType.H_STOCK
        );
    }
}
