package com.fast.programming.enums;

public enum StockType {
    STOCK("0", "股票", "STOCK"),
    FUND("1", "基金", "FUND"),
    RATION("3", "配股权证", "RATION"),
    NORMAL_APPLY("4", "普通申购", "NORMAL_APPLY"),
    APPLY_BACK("5", "申购回款", "APPLY_BACK"),
    INVEST_FUND("6", "投资基金", "INVEST_FUND"),
    ADD_APPLY("7", "增发申购", "ADD_APPLY"),
    SPECIAL("8", "特殊业务", "SPECIAL"),
    DEBT("9", "记账国债", "DEBT"),
    FUND_RANSOM("A", "基金申赎", "FUND_RANSOM"),
    FUND_BONUS("B", "基金设红", "FUND_BONUS"),
    CROSS_TRANSFEREE("C", "跨市转托", "CROSS_TRANSFEREE"),
    TRAD_WARRANTS("D", "交易权证", "TRAD_WARRANTS"),
    APPLY_NUM("E", "申购配号", "APPLY_NUM"),
    EXERCISE_WARRANTS("F", "行权权证", "EXERCISE_WARRANTS"),
    DEBT_APPLY("G", "国债申购", "DEBT_APPLY"),
    DEBT_BACK_MONEY("H", "国债回款", "DEBT_BACK_MONEY"),
    DEBT_DIST("I", "国债分销", "DEBT_DIST"),
    FUND_APPLY("J", "基金申购", "FUND_APPLY"),
    FUND_SUB("K", "基金认购", "FUND_SUB"),
    LOF_FUND("L", "LOF基金", "LOF_FUND"),
    ETF_SUB("M", "ETF认购", "ETF_SUB"),
    ETF_RANSOM("N", "ETF申赎", "ETF_RANSOM"),
    ETF_CHANGE("O", "基金转换", "ETF_CHANGE"),
    PLACE_PURCHASE("P", "配售申购", "PLACE_PURCHASE"),
    ENTERPRISE_REPURCHASE("Q", "企债回购", "ENTERPRISE_REPURCHASE"),
    SPECIFY_TRADE("R", "指定交易", "SPECIFY_TRADE"),
    SUB_MONEY("S", "认购款", "SUB_MONEY"),
    ETF_FUND("T", "ETF基金", "ETF_FUND"),
    ENTERPRISE_DEBT("U", "企业债券", "ENTERPRISE_DEBT"),
    ETF_BALANCE("V", "ETF资金", "ETF_BALANCE"),
    PROOF_DEBT("X", "凭证国债", "PROOF_DEBT"),
    ENTERPRISE_T_DEBT("Y", "企业转债", "ENTERPRISE_T_DEBT"),
    DEBT_BACK("Z", "国债回购", "DEBT_BACK"),
    PRIVATE_DEBT("a", "私募债", "PRIVATE_DEBT"),
    GEM("c", "创业板", "GEM"),
    PLEDGE_CODE("f", "质押代码", "PLEDGE_CODE"),
    H_STOCK("h", "H股", "H_STOCK"),
    CURRENCY_ETF_RANSOM("i", "货币ETF申赎", "CURRENCY_ETF_RANSOM"),
    CURRENCY_ETF_FUND("j", "货币ETF基金", "CURRENCY_ETF_FUND"),
    DEBT_ETF_RANSOM("k", "国债ETF申赎", "DEBT_ETF_RANSOM"),
    DEBT_ETF_FUND("l", "国债ETF基金", "DEBT_ETF_FUND"),
    INFO_SHARE_TRANSFER("m", "资管份额转让", "INFO_SHARE_TRANSFER"),
    CORPORATE_BONDS("u", "公司债", "CORPORATE_BONDS"),
    SOLID_CHARGE("x", "固收品种", "SOLID_CHARGE"),
    OFFER_SHARES("z", "报价股份", "OFFER_SHARES"),

    BOND("treasure", "国债", "TREASURE_BONDS"),
    REPO("REPO", "回购", "REPO");

    public final String value;
    public final String name;
    public final String alias;

    private StockType(String value, String name, String alias) {
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
}
