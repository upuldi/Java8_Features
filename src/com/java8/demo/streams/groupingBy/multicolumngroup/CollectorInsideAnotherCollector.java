package com.java8.demo.streams.groupingBy.multicolumngroup;

import com.java8.demo.streams.groupingBy.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by L078878 on 15/02/2017.
 */
public class CollectorInsideAnotherCollector {

    public static void main(String[] args) {

        //There are multiple ways of grouping by

        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );


        /* When you have more than one column to grouping by*/
        Map<String, Map<Integer, List<Item>>> twoColumnsGrouping = items.stream().collect(Collectors.groupingBy(Item::getName,
                Collectors.groupingBy(Item::getQty)));
        System.out.println(twoColumnsGrouping);

    }
}
