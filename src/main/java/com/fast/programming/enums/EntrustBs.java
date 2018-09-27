package com.fast.programming.enums;

public enum EntrustBs {
    BUY("1", "买入", "BUY"),
    SELL("2", "卖出", "SELL"),
    MARKET_BUY("3", "市价买入", "BUY"),
    MARKET_SELL("4", "市价卖出", "SELL"),
    DIVIDEND("5", "送股", "DIVIDEND"),
    BONUS("6", "派息", "BONUS"),
    REGISTER_ASSIGN("7", "登记指定", "REGISTER_ASSIGN");

    private final String value;
    private final String name;
    private final String alias;

    private EntrustBs(String value, String name, String alias) {
        this.value = value;
        this.name = name;
        this.alias = alias;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public boolean isStockTrade() {
        return isStockBuy() || isStockSale();
    }

    public boolean isStockBuy() {
        return BUY.equals(this) || MARKET_BUY.equals(this);
    }

    public boolean isStockSale() {
        return SELL.equals(this) || MARKET_SELL.equals(this);
    }

    public boolean isStockDividend() {
        return DIVIDEND.equals(this);
    }

    public boolean isStockBonus() {
        return BONUS.equals(this);
    }
}
