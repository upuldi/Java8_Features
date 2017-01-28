package com.java8.demo.functions.summary;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Created by udoluweera on 1/28/17.
 */
public class SupplierSummary {

    public static void main(String[] args) {

        //Suppliers are used to supply something
        //They don't take any input values but returns a value
        // get()  method is used to get the value from the supplier

        Supplier<Double> someRandomNumber = Math::random;
        Double result = someRandomNumber.get();
        System.out.println(result);

        Supplier<String> someStringSupplier = () -> "Hello world";
        System.out.println(someStringSupplier.get());

        //For Primitives
        //They have different methods depending on the class for ex: getAsInt() instead of get()

        IntSupplier alwaysFive = () -> 5;
        System.out.println(alwaysFive.getAsInt());

        DoubleSupplier absoluteOneHundradValue = () ->  Math.abs(100.1212121212d);
        System.out.println(absoluteOneHundradValue.getAsDouble());





    }
}
