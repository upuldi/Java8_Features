package com.java8.demo.functions.function;

import java.util.function.*;

/**
 * Created by udoluweera on 8/7/16.
 */
public class PrimitiveFunctions {


    Predicate<Integer> somePredicateWithIntegerInputToTestEvenNos = (x) -> x%2 ==0;

    /* The above type of predicates are not fast as we are using Wrapper objects instead of  primitive type.
    * We can use the available primitive predicates as bellow */

    IntPredicate intPredicateSameAsAbove = (x) -> x%2 == 0;
    LongPredicate aLongPredicate = (l) -> l%2 == 0;
    DoublePredicate doublePredicate = (d) -> d%2==0;

    //Also there are primitive consumers
    IntConsumer intConsumer = (i) -> System.out.println("this is an inte consumer which accept a int " + i);
    LongConsumer longConsumer = null;
    DoubleConsumer doubleConsumer = null;

    //Same as Suppliers
    IntSupplier intSupplier = null;
    LongSupplier longSupplier = null;
    DoubleSupplier doubleSupplier = null;

    //Functions can be defined in many ways
    //A typical function is defined as below. This function takes a Integer and reurns a SomeObject as the response
    Function<Integer,SomeReturnObject> someFunctionDefinition = null;
    // It can be defined as this,Here we only defined the return type as we know IntFunction take an primitive int as the input
    IntFunction<SomeReturnObject> sameFunctionWithPrimitiveInts = null;

    //Same as int other types goes
    LongFunction<SomeReturnObject> longFunction = null;
    DoubleFunction<SomeReturnObject> doubleFunction = null;

    /* But what about a function which takes an int as the input and returns a double as the output
    *  in other words primitive to primitive functions */
    Function<Integer,Double> intInputAndDoubleOutputFunction = null;
    //We can use the above functions as this,
    IntFunction<Double> intInputButDoubleObjOutPutFunction  = null;
    // Though the above function takes an int as the  input it still does return a Double object as the output, its not a double primitive
    //So we have this
    IntToDoubleFunction intInputDoubleOutPutFunction = null; //Primitive int to primitive double
    IntToLongFunction intToLongFunction = null;
    LongToDoubleFunction longToDoubleFunction = null;//Primitive long to primitive double
    //Likewise there are many primitive converting functions....


    private void testEvenNumbers() {
        Boolean res = somePredicateWithIntegerInputToTestEvenNos.test(11);
        System.out.println("11 testing : " + res);
        res = somePredicateWithIntegerInputToTestEvenNos.test(6);
        System.out.println("6 testing : " + res);
    }
    private void testEvenNumbersWithIntPredicate() {
        Boolean res = intPredicateSameAsAbove.test(12);
        System.out.println("Int pre 12 testing : " + res);
        res = intPredicateSameAsAbove.test(9);
        System.out.println("Int pre 9 testing : " + res);
    }



    public static void main(String[] args) {

        new PrimitiveFunctions().testEvenNumbers();
        new PrimitiveFunctions().testEvenNumbersWithIntPredicate();

    }

    class SomeReturnObject {}
}
