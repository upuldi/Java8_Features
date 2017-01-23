package com.java8.demo.lambda.syntax;

import java.util.function.Function;

/**
 * This class demonstrate how to use lambdas in methods effectively.
 *
 * Created by udoluweera on 9/17/16.
 */
public class FunctionsWithLambdasDemo {


    /**
     * This method doesnt know about the behaviour, instead the behaviour is being passed to this method.
     * The beauty of this is that depending on the parameter you passed the behaviour of this method will be
     * changed.
     *
     * @param input
     * @param function
     * @return
     */
    private String emailComposer(String input,Function<String,String> function) {
        return function.apply(input);
    }

    public static void main(String[] args) {

        FunctionsWithLambdasDemo oneObject = new FunctionsWithLambdasDemo();

        //When you want to compose a gmail email
        String gmailEmail = oneObject.emailComposer("upul",s-> s+"gmail.com" );
        System.out.println(gmailEmail);

        //For yahoo
        String yahooEmail = oneObject.emailComposer("upul",s-> s+"yahoo.com");
        System.out.println(yahooEmail);

    }
}
