package com.java8.demo.functions.summary;

import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * Created by udoluweera on 1/28/17.
 */
public class PremitiveFunctionsSummary {

    public static void main(String[] args) {

        //Because of the performance we use premitive functions over WrapperFunctions
        Function<Integer,Double> someFunctionWithWrapperObjects = (i) -> i*1.12;

        IntFunction<Double> sameFunctionWithIntInput = (i) -> i * 1.3;

        /*The other benefit is that you don't need to mention the input with primitive functions */




    }
}
