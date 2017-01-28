package com.java8.demo.lambda.summary;


import temp.practice.AnotherObjectClass;
import temp.practice.SomeObjectClass;

/**
 * Created by udoluweera on 1/24/17.
 */

class UtilClass {
    static boolean checkMethod(String someSting) { return someSting.length() > 5 ? true : false;}
}

/**
 * This class provides a summary of method referencing in Lambda Expressions
 */
public class LambdaBasic {

    @FunctionalInterface
    interface SomeFunctionalInterface {

        boolean somePredicate(String someString);

        static boolean staticMethodWithSameSignatureAsFunction(String someSting) {
            //Provides some implementation to the method.
            return someSting.isEmpty();
        }
    }

    @FunctionalInterface
    interface SomeOtherFunctionalInterface {
        boolean someOtherFunction(SomeOtherClass someOtherClass);
    }

    @FunctionalInterface
    interface SomeFunctionalSupplier {
        SomeObjectClass someSupplier(String x);
    }

    @FunctionalInterface
    interface AnotherFunctionalSupplier {
        AnotherObjectClass anotherSupplierWhichAcceptTwoParameters(String x, int y);
    }

    public void someNonStaticMethodReferenceDemo() {
        SomeOtherFunctionalInterface nonStaticMethodReferenceOnInputs = (o) -> o.someOtherClassMethod();
        SomeOtherFunctionalInterface nonStaticMethodReferenceOnInputsWithMethodReference = SomeOtherClass::someOtherClassMethod;
    }


    public boolean nonStaticMethodInSomeOtherClass(String someString) {
        return true;
    }


    public static void main(String[] args) {

        //Here we are defining lambdas
        SomeFunctionalInterface someLambdaExpression  = (String s) -> s.length() > 2 ? true:false;

        //Definition of the type is not mandatory
        SomeFunctionalInterface moreElegantExpression  = (s) -> s.length() > 2 ? true:false;

        //You can remove the braces as well
        SomeFunctionalInterface moreElegantExpressionWithoutBraces  = s -> s.length() > 2 ? true:false;

        //Since there is only one method call
        SomeFunctionalInterface moreElegantExpressionWhenCallingSingleMethod  = UtilClass::checkMethod;

        //It is similar to calling a static method directly.(same rule)
        SomeFunctionalInterface staticMethodReference = SomeFunctionalInterface::staticMethodWithSameSignatureAsFunction;

        //However if the function call is on one of its inputs, You can use method references
        //The biggest difference is that this call was made on a one of the parameter of the function
        //Otherwise the method which is being called should be static.
        SomeFunctionalInterface nonStaticMethodReference = String::isEmpty;
        //Have a look at this
        new LambdaBasic().someNonStaticMethodReferenceDemo();

        //You can reference methods on instance variables
        LambdaBasic someLambdaBasicInstance = new LambdaBasic();
        //So if it not a static method or you are not calling a method on its parameters of a functional method
        SomeFunctionalInterface methodReferenceOnInstanceVariables = someLambdaBasicInstance::nonStaticMethodInSomeOtherClass;

        //You can do method references on instances, So if a method is static or invoking method on  a parameter
        // or if it is an instance variable you can do the method referencing...
        SomeFunctionalInterface methodReferenceOnArbitaryTypes = new SomeOtherClass()::someOtherClassMethod;

        //Constructor reference
        SomeFunctionalSupplier withOneArgumentAnotherWay = (s) -> new SomeObjectClass(s);
        SomeFunctionalSupplier withOneArgumentElegantWay = SomeObjectClass::new; //Here we don't provides the passing parameter

        AnotherFunctionalSupplier withTwoArgumentConstructor = (s,i) -> new AnotherObjectClass(s,i);
        AnotherFunctionalSupplier withTwoArgumentConstructorMoreElegant  = AnotherObjectClass::new;

    }
}
