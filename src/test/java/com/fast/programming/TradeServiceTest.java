package com.fast.programming;

import com.fast.programming.service.condition.CheckCondition;
import com.fast.programming.service.designpatterns.command.Command;
import com.fast.programming.service.designpatterns.observer.IdeaIDEActionCenter;
import com.fast.programming.service.example.field.GetAndSetFieldValue;
import com.fast.programming.service.example.loop.ContinueBreak;
import com.fast.programming.service.example.loop.DateIterator;
import com.fast.programming.service.example.search.IfElseCheck;
import com.fast.programming.service.example.search.NullOptional;
import com.fast.programming.service.groupby.GroupBy;
import com.fast.programming.service.groupby.MinMaxAvgSum;
import com.fast.programming.service.groupby.PartitionBy;
import com.fast.programming.service.groupby.ToMap;
import com.fast.programming.service.misc.ArraysOperation;
import com.fast.programming.service.misc.Debug;
import com.fast.programming.service.misc.IteratorStream;
import com.fast.programming.service.misc.StringJoin;
import com.fast.programming.service.misc.StringJoin2;
import com.fast.programming.service.orderby.OrderBy;
import com.fast.programming.service.search.Filter;
import com.fast.programming.service.search.Search;

import org.junit.Test;

/**
 * @author bowen.yan
 * @date 2018-09-27
 */
public class TradeServiceTest {
    // condition
    @Test
    public void test_CheckCondition() {
        new CheckCondition().run();
    }

    // groupby
    @Test
    public void test_GroupBy() {
        new GroupBy().run();
    }

    @Test
    public void test_MinMaxAvgSum() {
        new MinMaxAvgSum().run();
    }

    @Test
    public void test_PartitionBy() {
        new PartitionBy().run();
    }

    @Test
    public void test_ToMap() {
        new ToMap().run();
    }

    // orderby
    @Test
    public void test_OrderBy() {
        new OrderBy().run();
    }

    // search
    @Test
    public void test_Search() {
        new Search().run();
    }

    @Test
    public void test_Filter() {
        new Filter().run();
    }

    // misc
    @Test
    public void test_ArraysOperation() {
        new ArraysOperation().run();
    }

    @Test
    public void test_Debug() {
        new Debug().run();
    }

    @Test
    public void test_StringJoin() {
        new StringJoin().run();
    }

    @Test
    public void test_StringJoin2() {
        new StringJoin2().run();
    }

    // design patterns
    @Test
    public void test_Command() {
        new Command().run();
    }

    @Test
    public void test_IdeaIDEActionCenter() {
        new IdeaIDEActionCenter().run();
    }

    @Test
    public void test_IteratorStream() {
        new IteratorStream().run();
    }

    // example
    @Test
    public void test_GetAndSetFieldValue() {
        new GetAndSetFieldValue().run();
    }

    @Test
    public void test_DateIterator() {
        new DateIterator().run();
    }

    @Test
    public void test_IfElseCheck() {
        new IfElseCheck().run();
    }

    @Test
    public void test_NullOptional() {
        new NullOptional().run();
    }

    @Test
    public void test_ContinueBreak() {
        new ContinueBreak().run();
    }
}
