package com.fast.programming.model;

import com.fast.programming.enums.EntrustBs;

import java.util.Date;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class Trade implements Comparable<Trade> {
    private User user;
    private Security security;
    private EntrustBs entrustBs;
    private double dealAmount;
    private double dealPrice;
    private Date dealTime;

    public Trade() {
    }

    public Trade(User user, Security security, EntrustBs entrustBs, double dealAmount, double dealPrice, Date dealTime) {
        this.user = user;
        this.security = security;
        this.entrustBs = entrustBs;
        this.dealAmount = dealAmount;
        this.dealPrice = dealPrice;
        this.dealTime = dealTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public EntrustBs getEntrustBs() {
        return entrustBs;
    }

    public void setEntrustBs(EntrustBs entrustBs) {
        this.entrustBs = entrustBs;
    }

    public double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(double dealAmount) {
        this.dealAmount = dealAmount;
    }

    public double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public double getDealBalance() {
        return dealAmount * dealPrice;
    }

    @Override
    public int compareTo(Trade o) {
        if (o == null || o.getUser() == null) {
            return 1;
        }
        return this.getUser().getUserName().compareTo(o.getUser().getUserName());
    }

    @Override
    public String toString() {
        return "Trade{" +
                "user=" + user +
                ", security=" + security +
                ", entrustBs=" + entrustBs.getName() +
                ", dealAmount=" + dealAmount +
                ", dealPrice=" + dealPrice +
                ", dealTime=" + dealTime +
                '}';
    }
}
