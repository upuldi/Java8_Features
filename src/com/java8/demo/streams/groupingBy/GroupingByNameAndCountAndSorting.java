package com.java8.demo.streams.groupingBy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by udoluweera on 1/29/17.
 */
public class GroupingByNameAndCountAndSorting {

    public static void main(String[] args) {

        //Sorted map by name

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");


        Map<String, Long> groupByNameResponse = items.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                Collectors.counting()));
        System.out.println(groupByNameResponse);

        Map<String,Long> linkedHashMap = new LinkedHashMap<>();

        //Sorting
        groupByNameResponse.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> linkedHashMap.put(e.getKey(), e.getValue()));

        System.out.println(linkedHashMap);






    }
}
