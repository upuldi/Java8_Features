package com.java8.demo.functions.summary;

import java.util.function.*;

/**
 * Created by udoluweera on 1/28/17.
 */
public class FunctionSummary {

    public static void main(String[] args) {

        //Apply() method executes a function


        Function<String,Integer> stringLength = (s) -> s.length();
        Integer result = stringLength.apply("12345");
        System.out.println(result);

        Function<Integer,Double> doubleFunction = (i) -> i * 0.1235;

        Function<String,Double> functionSequence = stringLength.andThen(doubleFunction);
        Double endResult = functionSequence.apply("AGCDR");
        System.out.println(endResult);

        /* Composing functions are different to andThen() functions
        * As
        *    1. Composing functions should be of same input and output types
        *    2. Passing function will get executed first. functionOne.Compose(functionTwo)
        *
        *    In other words composed functions are making two function calls at once.
        * */

        Function<String,String> functionOne = (s) -> { String k = s.toUpperCase(); System.out.println("Function One : " + k); return k; };
        Function<String,String> functionTwo = (s) -> { String k = s.toLowerCase(); System.out.println("Function Two : " +  k); return k; };

        Function<String,String> composedFunction = functionOne.compose(functionTwo);
        String composedResult = composedFunction.apply("someComPosedFunReSULt");
        System.out.println(composedResult);


        //BiFunctions
        BiFunction<Integer,Double,String> multiplyAndDecorate = (i,d) -> String.format("** %f **",i*d);
        String biResponse = multiplyAndDecorate.apply(5,5.5);
        System.out.println(biResponse);

        //You can andThen() bifunction and a normal function
        BiFunction<Integer,Double,Integer> biAndThenFunction =  multiplyAndDecorate.andThen(stringLength);
        Integer biAndThenResponse = biAndThenFunction.apply(10,1.1);
        System.out.println(biAndThenResponse);

        //Primitives
        IntFunction<String> primitiveIntFunction = Integer::toString;
        System.out.println(primitiveIntFunction.apply(Integer.valueOf(1000)));

        DoubleFunction<String> primitiveDoubleFunction = (d) -> String.format("## %f ##",d);
        System.out.println(primitiveDoubleFunction.apply(13.25));

        //Since all the return types of above functions are still wrapped objects
        //for ex
        IntFunction<Long> intToLongConversion = (i) -> new Long(i);

        //So the solution is to use following functions which gurentee the both types are premitives
        IntToLongFunction intInputLongOutPut = (i) -> Long.valueOf(i);
        LongToDoubleFunction longToDouleFunction = null;






    }
}
