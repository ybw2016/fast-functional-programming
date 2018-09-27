package com.fast.programming.service;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class TimesCounter {
    public static final TimesCounter DEFAULT_TRADE_TIMES_COUNTER = new TimesCounter("MaYun", 2);

    private String key;
    private long count;

    public TimesCounter() {

    }

    public TimesCounter(String key, long count) {
        this.key = key;
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
