package com.fast.programming.model;

import com.fast.programming.enums.ExchangeType;
import com.fast.programming.enums.StockType;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class Security {
    public static final Security S_000725 = new Security("000725", "京东方A ", 2.34, StockType.STOCK, ExchangeType.SZ);
    public static final Security S_600856 = new Security("600856", "中天能源", 11.62, StockType.STOCK, ExchangeType.SH);
    public static final Security S_601216 = new Security("601216", "君正集团", 5.21, StockType.STOCK, ExchangeType.SH);
    public static final Security S_002502 = new Security("002502", "威驰文化", 27.80, StockType.STOCK, ExchangeType.SZ);
    public static final Security S_002157 = new Security("002157", "正邦科技", 7.60, StockType.STOCK, ExchangeType.SZ);
    public static final Security S_160219 = new Security("160219", "国泰医药", 1.60, StockType.FUND, ExchangeType.CW);
    public static final Security S_150130 = new Security("150130", "国药A", 1.20, StockType.FUND, ExchangeType.SZ);
    public static final Security S_150131 = new Security("150131", "国药B", 2.00, StockType.FUND, ExchangeType.SZ);
    public static final Security S_150005 = new Security("150005", "15附息国债05", 102.60, StockType.BOND, ExchangeType.YH);

    public static final Security S_600000 = new Security("600000", "浦发银行", 20.35, StockType.STOCK, "SH");
    public static final Security S_000002 = new Security("000002", "万科A", 9.29, StockType.STOCK, "SZ");

    private String stockCode;
    private String stockName;
    private double closePrice;
    private StockType stockType;
    private ExchangeType exchangeType;
    private String exchTypeStr;

    public Security(String stockCode, String stockName, double closePrice, StockType stockType, String exchTypeStr) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.closePrice = closePrice;
        this.stockType = stockType;
        this.exchTypeStr = exchTypeStr;
    }

    public Security(String stockCode, String stockName, double closePrice, StockType stockType, ExchangeType exchangeType) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.closePrice = closePrice;
        this.stockType = stockType;
        this.exchangeType = exchangeType;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public StockType getStockType() {
        return stockType;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getExchTypeStr() {
        return exchTypeStr;
    }

    public void setExchTypeStr(String exchTypeStr) {
        this.exchTypeStr = exchTypeStr;
    }

    @Override
    public String toString() {
        return "Security{" +
                "stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", closePrice=" + closePrice +
                ", stockType=" + stockType.getName() +
                ", exchangeType=" + exchangeType +
                ", exchTypeStr=" + exchTypeStr +
                '}';
    }
}
