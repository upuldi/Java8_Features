package com.java8.demo.lambda.typeInference;

import java.util.List;

/**
 * Created by udoluweera on 8/1/16.
 */
public class TypeInferenceDemo {

    public interface SomeFunctionalInterface {
        public List<Integer> someComplexMethod(List<String> aStringList,List<Integer> aIntegerList,Double d);
    }


    public static void main(String[] args) {

        //We can define the types like this
        SomeFunctionalInterface someFunctionalInterface = (List<String> aStringList,List<Integer> aIntegerList,Double d) -> {
            System.out.println("Inside the functional method, providing the running logic");
            return null;
        };

        //Without the type definitions
        SomeFunctionalInterface simpleAndNice = (aStringList,aIntegerList,d) -> {
            System.out.println("Simple and elegant");
            return null;
        };





    }
}
