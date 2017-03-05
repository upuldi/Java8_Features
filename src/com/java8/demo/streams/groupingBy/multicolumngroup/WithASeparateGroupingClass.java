package com.java8.demo.streams.groupingBy.multicolumngroup;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by L078878 on 15/02/2017.
 */
public class WithASeparateGroupingClass {

    public static void main(String[] args) {

        List<Fruit> fruits = getFruitsList();


        /**
         * Fruit Class Contains a nested inner class containing fields that will be needed for grouping
         * Also it contains a method which will return a instance of the GroupingClass
         *
         * The disadvantage of this approach is that the need of having a separate class for grouping
         */

        Map<Fruit.NameAndQty, List<Fruit>> nameAndQtyGroupedList = fruits.stream().collect(Collectors.groupingBy(Fruit::getNameAndQty));
        System.out.println(nameAndQtyGroupedList);
        
        

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
