package com.fast.programming.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public abstract class FeatureBase {
    protected String getComment() {
        return StringUtils.EMPTY;
    }

    protected abstract void runOld();

    protected abstract void runNew();

    protected void runMisc() {
    }

    public void run() {
        String comment = getComment();
        if (StringUtils.isNotEmpty(comment)) {
            System.out.println(comment);
            System.out.println();
        }

        System.out.println("----------------------------normal programming----------------------------");
        runOld();

        System.out.println(System.getProperty("line.separator"));

        System.out.println("----------------------------functional programming----------------------------");
        runNew();

        System.out.println(System.getProperty("line.separator"));
        runMisc();
    }

    public void printTitle(String title) {
        System.out.println("----------" + title + "----------");
    }

    public void println() {
        System.out.println();
    }

    public void println(Object obj) {
        println("", obj);
    }

    public void println(String title, Object obj) {
        System.out.println(title + ": " + obj);
    }

    private void printTimeSeconds(Date startTime, Date endTime) {
        println("耗时: " + (startTime.getTime() - endTime.getTime()) + "s");
    }
}

