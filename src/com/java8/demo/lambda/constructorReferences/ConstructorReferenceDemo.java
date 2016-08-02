package com.java8.demo.lambda.constructorReferences;

import com.java8.demo.lambda.methodReferences.MethodReferenceDemo;

/**
 * Created by udoluweera on 8/1/16.
 */
public class ConstructorReferenceDemo {

    public interface ObjectFactory {
        public SomeObject constructObject(int x);
    }

    public interface AnotherFactory {
        public SomeObject aMethodWhichInvokesAllArgumentConstructor(int x,String y);
    }

    public static void main(String[] args) {

        //Constructor reference example
        ObjectFactory withoutReferencing = (x) -> new SomeObject(x);

        //With referencing..
        ObjectFactory withReferencing = SomeObject::new;
        //This above code will invoke the constructor with one argument as the ObjectFactory fnctional interface only
        //accepts one argument

        //Even though this call is similar to the above line, this will calls the two argument constructor because of the
        //Functional interface it has accepts two arguments matching the constructor
        AnotherFactory withRefAllArgument = SomeObject::new;





    }

}
