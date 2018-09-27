package com.fast.programming.service.misc;

import com.fast.programming.service.FeatureBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * input:  String[] hobbies = {"Basketball", "Football", "Pingpang", "Billards"}
 * output: [Basketball, Football, Pingpang, Billards]
 *
 * @author bowen.yan
 * @since 2016-09-15
 */

public class StringJoin2 extends FeatureBase {
    private List<String> getHobbies() {
        String[] hobbies = {"Basketball", "Football", "Pingpang", "Billards"};
        return Arrays.asList(hobbies);
    }

    @Override
    protected void runOld() {
        StringBuilder builder = new StringBuilder("[");
        for (String hobby : getHobbies()) {
            if (builder.length() > 1) {
                builder.append(",");
            }
            builder.append(hobby);
        }
        builder.append("]");
        println(builder);
    }

    @Override
    protected void runNew() {
        String hobbyStr = getHobbies()
                .stream()
                .collect(Collectors.joining(", ", "[", "]"));
        println(hobbyStr);
    }
}
