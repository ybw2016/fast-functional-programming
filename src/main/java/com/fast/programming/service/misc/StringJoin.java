package com.fast.programming.service.misc;

import com.fast.programming.service.FeatureBase;

import java.util.Arrays;
import java.util.List;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class StringJoin extends FeatureBase {
    @Override
    protected String getComment() {
        return "从一组值生成一个值 -> 字符串、数值计算等";
    }

    private List<String> getHobbies() {
        String[] hobbies = {"Basketball", "Football", "Pingpang", "Billards"};
        return Arrays.asList(hobbies);
    }

    @Override
    protected void runOld() {
        String hobbyStr = "";
        for (String hobby : getHobbies()) {
            hobbyStr += hobby + ",";
        }
        println(hobbyStr);
        //System.out.println(StringUtils.join(getHobbies(), ","));
    }

    @Override
    protected void runNew() {
        String hobbyStr = getHobbies()
                .stream()
                .reduce("", (current, next) -> current + next + ",");
        println(hobbyStr);

//        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        int result = arr.stream().reduce(0, (current, next) -> current + next);
//        System.out.println(result);
    }
}
