package com.fast.programming.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date parse(String date) {
        try {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.parse(date);
        } catch (Exception ex) {
            return null;
        }
    }
}
