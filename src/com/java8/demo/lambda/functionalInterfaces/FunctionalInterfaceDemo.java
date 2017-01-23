package com.java8.demo.lambda.functionalInterfaces;


/**
 * Created by udoluweera on 8/1/16.
 */
public class FunctionalInterfaceDemo {

    @FunctionalInterface
    public interface NumberCalculator {
        public int calculate(int a,int b);
    }

    /**
     * See the method definition, It doesnt mutate the data, just pass to the functional interface
     */
    public int numberService(int x,int y, NumberCalculator numberCalculator) {
        return numberCalculator.calculate(x,y);
    }

    public static void main(String[] args) {

        FunctionalInterfaceDemo functionalInterfaceDemo = new FunctionalInterfaceDemo();

        /* There are various ways of invoking the service using lambda */

        int ans = functionalInterfaceDemo.numberService(10,20, (x,y)-> x+y);
        System.out.println("Add : " + ans );

        ans = functionalInterfaceDemo.numberService(20,10, (x,y)-> x/y);
        System.out.println("Devi : " + ans );

        ans = functionalInterfaceDemo.numberService(20,10, (x,y)-> x-y);
        System.out.println("Sub : " + ans );

        ans = functionalInterfaceDemo.numberService(20,10, (x,y)-> x*y);
        System.out.println("Multi : " + ans );

        ans = functionalInterfaceDemo.numberService(25,10, (x,y)-> x%y);
        System.out.println("Mod : " + ans );
    }
}
