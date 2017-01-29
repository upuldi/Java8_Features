package com.java8.demo.streams.groupingBy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by udoluweera on 1/29/17.
 */
public class GroupingWithObj {


    public static void main(String[] args) {

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

        //Name vs count
        Map<String, Long> nameVsCount = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(nameVsCount);

        //Name vs quantity
        Map<String, Integer> nameVsQty = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        System.out.println(nameVsQty);

        //Price
        Map<BigDecimal, List<Item>> groupByPrice = items.stream().collect(Collectors.groupingBy(Item::getPrice));
        System.out.println(groupByPrice);

        //Group by Price and only name of the item
        Map<BigDecimal, Set<String>> priceVsName = items.stream().collect(
                Collectors.groupingBy(
                        Item::getPrice, Collectors.mapping(
                                Item::getName, Collectors.toSet()
                        )
                )
        );

        System.out.println(priceVsName);

    }
}
