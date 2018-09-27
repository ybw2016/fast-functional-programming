package com.fast.programming.model;

import com.fast.programming.enums.AreaEnum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class User implements Comparator<User> {
    public static final User LI_YAN_HONG = new User(1, "李彦宏", AreaEnum.BJ);
    public static final User MA_YUN = new User(2, "马云", AreaEnum.HZ);
    public static final User MA_HUA_TENG = new User(3, "马化腾", AreaEnum.SZ);
    public static final User REN_ZHENG_FEI = new User(4, "任正非", AreaEnum.SZ);
    public static final User LIU_QINAG_DONG = new User(5, "刘强东", AreaEnum.BJ);
    public static final User LEI_JUN = new User(6, "雷军", AreaEnum.BJ);
    public static final User ZHOU_HONG_YI = new User(7, "周鸿祎", AreaEnum.BJ);

    private int userId;
    private String userName;
    private AreaEnum areaEnum;

    public User(int userId, String userName, AreaEnum areaEnum) {
        this.userId = userId;
        this.userName = userName;
        this.areaEnum = areaEnum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AreaEnum getAreaEnum() {
        return areaEnum;
    }

    public void setAreaEnum(AreaEnum areaEnum) {
        this.areaEnum = areaEnum;
    }

    public boolean isFromBeijing() {
        return AreaEnum.BJ.equals(areaEnum);
    }

    public boolean isBAT() {
        return Arrays.asList(User.LI_YAN_HONG, User.MA_YUN, User.MA_HUA_TENG).contains(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", areaEnum=" + areaEnum.getName() +
                '}';
    }

    @Override
    public int compare(User o1, User o2) {
        if (o2 == null) {
            return 1;
        }
        return o1.getUserName().compareTo(o2.getUserName());
    }
}
