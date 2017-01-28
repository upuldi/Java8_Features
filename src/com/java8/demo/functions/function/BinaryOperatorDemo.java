package com.java8.demo.functions.function;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * Created by udoluweera on 1/28/17.
 */
public class BinaryOperatorDemo {

    public static void main(String[] args) {
        /**
         * Binary Operator extends BiFunction interface
         * All the inputs and the outputs are same
         */

        BiFunction<String,Integer,Double> biFunction = (s,i) -> s.length() * i * 0.124;

        BinaryOperator<String> allStringInputsAndOutPuts = (a,b) -> a.concat(b);
        System.out.println(allStringInputsAndOutPuts.apply("Hello"," binary operator"));

        /* apart from the standard BiFunction methods there are some additional methods in BinaryOperator */

        //MinBy() is used to find the small value based on the comparator
        BinaryOperator<Integer> minByDemo = BinaryOperator.minBy(Integer::compare);
        System.out.println(minByDemo.apply(10,20));

        //Here the comparator is the reverse order so the minimum would be the 30
        BinaryOperator<Integer> minByReverseOrder = BinaryOperator.minBy(Comparator.reverseOrder());
        System.out.println(minByReverseOrder.apply(20,30));

        //maxBy() is used to get the maximum value out of two values
        BinaryOperator<Integer> maxByDemo = BinaryOperator.maxBy(Integer::compare);
        System.out.println(maxByDemo.apply(40,60));

        BinaryOperator<Integer> maxByReverseDemo = BinaryOperator.maxBy(Comparator.reverseOrder());
        System.out.println(maxByReverseDemo.apply(40,60));
    }
}
