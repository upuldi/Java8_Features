package com.java8.demo.functions.function;

import com.java8.demo.lambda.constructorReferences.SomeObject;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by udoluweera on 8/8/16.
 */
public class BiFunctionsDemo {


    /**
     * BiFunctionsDemo takes two input parameters and return a result
     */
    //Here we define the two input parameters first and then the return type next
    BiFunction<String,Integer,SomeClass> biFunctionExample = SomeClass::new;

    //Aggregating bifunctions
    // the above bifunction returns a SomeObject so we have to use a normal function to accept that
    Function<SomeClass,String> someFunctionToGetName = (o) -> o.getName();

    //aggregating function
    //See here we are passing the inputs of the first function and expecting the out put of the next function.
    BiFunction<String,Integer,String> createObjectAndGetName = biFunctionExample.andThen(someFunctionToGetName);

    //There are no three argument functions provided by java8, if you need that you are expected to create them.


    public static void main(String[] args) {}

    class SomeClass {

        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public SomeClass(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

}
