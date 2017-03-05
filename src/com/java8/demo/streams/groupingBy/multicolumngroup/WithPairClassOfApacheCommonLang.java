package com.java8.demo.streams.groupingBy.multicolumngroup;

import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by L078878 on 15/02/2017.
 */
public class WithPairClassOfApacheCommonLang {

    public static void main(String[] args) {

        /**
         * Instead of writing a separate class for grouping, You can use apache common Pair class
         *
         */

        List<Fruit> fruits = getFruitsList();

        Map<Pair<String, Integer>, List<Fruit>> nameAndQtyGrouping =
                fruits.stream().collect(Collectors.groupingBy(f -> Pair.of(f.getName(), f.getQty())));

        System.out.println(nameAndQtyGrouping);




    }

    private static List<Fruit> getFruitsList() {
        return Arrays.asList(
                new Fruit("apple", 10, new BigDecimal("9.99")),
                new Fruit("banana", 20, new BigDecimal("19.99")),
                new Fruit("orang", 10, new BigDecimal("29.99")),
                new Fruit("watermelon", 10, new BigDecimal("29.99")),
                new Fruit("papaya", 20, new BigDecimal("9.99")),
                new Fruit("apple", 10, new BigDecimal("9.99")),
                new Fruit("banana", 10, new BigDecimal("19.99")),
                new Fruit("apple", 20, new BigDecimal("9.99"))
        );
    }
}
