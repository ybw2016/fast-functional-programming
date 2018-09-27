package com.fast.programming.enums;

public enum ExchangeType {
    FRONT_UNKNOWN_EXCHANGE("0", "前台未知交易所", "FRONT_UNKNOWN_EXCHANGE"),
    SH("1", "上海", "SH"),
    SZ("2", "深圳", "SZ"),
    YH("3", "银行间", "YH"),
    CW("4", "场外", "CW"),
    SPECIAL_A("9", "特转A", "SPECIAL_A"),
    SPECIAL_B("A", "特转B", "SPECIAL_B"),
    SH_B("D", "上海B", "SH_B"),
    SZ_B("H", "深证B", "SZ_B"),
    ZZ_QH("F1", "郑州交易所（期货）", "ZZ_QH"),
    DL_QH("F2", "大连交易所（期货）", "DL_QH"),
    SH_QH("F3", "上海交易所（期货）", "SH_QH"),
    JR_QH("F4", "金融交易所（期货）", "JR_QH"),
    HK("K", "香港", "HK"),
    MG("P", "美股", "MG");

    private final String value;
    private final String name;
    private final String alias;

    private ExchangeType(String value, String name, String alias) {
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

    /**
     * 根据name 来获取枚举类型.
     *
     * @param ename enum name
     * @return {@link ExchangeType}
     */
    public static ExchangeType getExchangeType(String ename) {
        for (ExchangeType exchangeType : ExchangeType.values()) {
            if (exchangeType.name().equalsIgnoreCase(ename)) {
                return exchangeType;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ExchangeType{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
