package com.java8.demo.streams.groupingBy.multicolumngroup;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

/**
 * Created by L078878 on 17/02/2017.
 */
public class CreatingCollectors {

    public static void main(String[] args) {

        List<Fruit> fruitsList = getFruitsList();

        //We are creating a collector here
        /**
         * Collector<TypeOfInput,MutableAccumilationType,ResultTypeOfReductionOPeration>
         *
         */
        Collector<Fruit,StringJoiner,String> allFruitsAsASingleString = Collector.of(
                () -> new StringJoiner(" | "), //Supplier
                (j,p) -> j.add(p.getName().toUpperCase()),   //Accumulator
                (j1,j2) -> j1.merge(j2),        // Combiner
                StringJoiner::toString          // finisher
        );

        String fruitsNamesInCaps = fruitsList.stream().distinct().collect(allFruitsAsASingleString);
        System.out.println(fruitsNamesInCaps);



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
