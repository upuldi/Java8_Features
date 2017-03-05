package com.java8.demo.streams.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by udoluweera on 1/29/17.
 */
public class GroupingBasic {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("kLm", "xyz", "ABC", "ab", "ABC", "PQRS", "a", "b", "c", "PQRS", "abc","A","klmn");

        //groupingBy - function
        //Perform a groupBy() operation
        //Returns a map of given key and list of elements for that given key
        Stream<String> firstStream = stringList.stream();
        Map<Integer, List<String>> groupedMap = firstStream.collect(Collectors.groupingBy(s -> s.length()));

        System.out.println(groupedMap);


        //groupingby - function and collector
        /*Overloaded groupingBy() function supports multi level grouping
        *   for that you are passing groupingBy(function,anotherGroupingBy)
        *   */
        Stream<String> multiLevelGrouping = stringList.stream();
        Map<Integer, Map<Boolean, List<String>>> multiLevelGroupingResult =
                multiLevelGrouping
                        .collect(Collectors.groupingBy(String::length,
                                Collectors.groupingBy(s -> Character.isUpperCase(s.charAt(0))))
                        );

        System.out.println(" Multilevel Grouping : "+ multiLevelGroupingResult);


        //GroupingByCount example
        Stream<String> groupByCount = stringList.stream();

        Map<String, Long> itemCount = groupByCount
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(itemCount);


        //Partitioning by
        /**
         * Special case of grouping by,
         * Convert the stream into a map based on provided predicate
         */
        Map<Boolean, List<String>> partRes = stringList.stream().collect(
                Collectors.partitioningBy(s -> s.length() > 2));
        System.out.println("Partitioning by res : " + partRes);


    }
}
