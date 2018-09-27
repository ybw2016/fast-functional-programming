package com.fast.programming.enums;

public enum AreaEnum {
    BJ("BJ", "北京"),
    SH("SH", "上海"),
    SZ("SZ", "深圳"),
    XA("XA", "西安"),
    HZ("HZ", "杭州");

    private final String value;
    private final String name;

    private AreaEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
