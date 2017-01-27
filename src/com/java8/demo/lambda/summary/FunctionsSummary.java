package com.java8.demo.lambda.summary;


import java.util.function.Function;

public class FunctionsSummary {

    public Boolean oneExampleOfUsingAFunction(String input, Function<String,Boolean> functionGetPassed) {
        return functionGetPassed.apply(input);
    }



    public static void main(String[] args) {

        FunctionsSummary functionsSummary = new FunctionsSummary();

        //This is the proper way of using a Function
        System.out.printf("This is a proper use of a function : %s", functionsSummary.oneExampleOfUsingAFunction("upul",String::isEmpty));



    }
}
