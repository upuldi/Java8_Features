package com.java8.demo.functions.function;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by udoluweera on 1/28/17.
 */
public class UnaryOperatorDemo {

    public static void main(String[] args) {

        /**
         * Unary Operator is a sub interface of a function
         * Only difference is a function can return any type other than its input type
         * however the unary operators must return the same type as of its input type
         * */
        Function<String,Integer> aStringToIntegerFunction = String::length;
        UnaryOperator<String> aUnaryOperator = String::toUpperCase;

        //Unary operators inherits all the methods of the function interface
        System.out.println(aUnaryOperator.apply("abcd"));

        //Identity returns the same input
        UnaryOperator<String> identityDemo = UnaryOperator.identity();
        System.out.println(identityDemo.apply("sameStrIngComesAsitIS"));

    }
}
