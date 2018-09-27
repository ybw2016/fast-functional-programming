package com.fast.programming.service.example.loop;

import com.fast.programming.service.FeatureBase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 日期段处理
 *
 * @author bowen.yan
 * @date 2018-08-08
 */
public class DateIterator extends FeatureBase {
    @Override
    protected String getComment() {
        return "日期处理 -> 使用无限流再创建时间段很方便";
    }

    @Override
    protected void runOld() {
        LocalDate startDate = LocalDate.of(2018, 7, 25);
        LocalDate endDate = LocalDate.of(2018, 8, 2);
        LocalDate currDate = startDate;
        while (!currDate.isAfter(endDate)) {
            System.out.println(currDate);
            currDate = currDate.plusDays(1);
        }
    }

    @Override
    protected void runNew() {
        String startDate = "2018-07-25";
        String endDate = "2018-08-02";
        getPeriodDates(startDate, endDate).forEach(System.out::println);
        System.out.println();
    }

    private static final String PATTERN_SHORT_TIME = "yyyy-MM-dd";
    private static final String PATTERN_INIT_DATE = "yyyyMMdd";

    /**
     * 日期格式转换.
     *
     * @param inputDate     现有日期串
     * @param srcPattern    现有格式
     * @param targetPattern 目标格式
     * @return 目标字符串
     */
    public static String parse(String inputDate, String srcPattern, String targetPattern) {
        LocalDate srcDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern(srcPattern));
        return srcDate.format(DateTimeFormatter.ofPattern(targetPattern));
    }

    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回.
     * startDate    =   "2018-07-30"
     * endDate      =   "2018-08-02"
     * 返回集合：
     * 2018-07-30
     * 2018-07-31
     * 2018-08-01
     * 2018-08-02
     *
     * @param startDate yyyyMMdd、yyyy-MM-dd
     * @param endDate   yyyyMMdd、yyyy-MM-dd
     * @return 日期集合
     */
    public static List<String> getPeriodDates(String startDate, String endDate) {
        if (!startDate.contains("-")) {
            startDate = parse(startDate, PATTERN_INIT_DATE, PATTERN_SHORT_TIME);
        }
        if (!endDate.contains("-")) {
            endDate = parse(endDate, PATTERN_INIT_DATE, PATTERN_SHORT_TIME);
        }
        return getPeriodDates(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回
     */
    public static List<String> getPeriodDates(LocalDate startDate, LocalDate endDate) {
        // 用起始时间作为流的源头，按照每次加一天的方式创建一个无限流
        return Stream.iterate(startDate, currDate -> currDate.plusDays(1))
                // 截断无限流，长度为起始时间和结束时间的差+1个
                .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1)
                // 由于最后要的是字符串，所以map转换一下
                .map(currDate -> currDate.toString())
                // 把流收集为List
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String startDate = "2018-07-25";
        String endDate = "2018-08-02";
        getPeriodDates(startDate, endDate).forEach(System.out::println);
        System.out.println();

        startDate = "20180725";
        endDate = "20180802";
        getPeriodDates(startDate, endDate).forEach(System.out::println);
    }
}
