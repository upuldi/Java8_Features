package com.java8.demo.lambda.syntax;

import com.java8.demo.lambda.capturingLambda.Trade;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by udoluweera on 8/1/16.
 */
public class LmbdaSyntaxDemo {

    public static void main(String[] args) {

        //Every lambda represent a behaviour, or else one implementation to a functional interface.

        /**  Syntax style
         (input) -> body */

        Consumer<String> consumer = (String name) -> System.out.println("Hello " + name);

        //We can omit the type along with paranthisis if there is only one input parameter,
        //However the type can be ommitted irrespective of the no of input parameters
        Consumer<String> anotherConsumer = name -> System.out.println("Hello " + name);

        //When there is nothing to pass
        Supplier supplier = () -> myMethodWithNoInputParameters();

        //Complex lambda expression
        BiFunction<Trade,BusinessLogicAlgorithem,Trade> complexFunction =  (Trade t, BusinessLogicAlgorithem algo) -> {
            //Business logic goes here
            algo.applyMoreLogic(t);
            algo.doSomthingElse(t);
            mySaveMethodToPersistTrade(t);
            return t;
        };


    }

    private static void mySaveMethodToPersistTrade(Trade t) {}

    class BusinessLogicAlgorithem{

        public void applyMoreLogic(Trade t) {}

        public void doSomthingElse(Trade t) {}
    }
    private static Object myMethodWithNoInputParameters() {
        return null;
    }
}
