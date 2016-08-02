package com.java8.demo.lambda.methodReferences;

/**
 * Created by udoluweera on 8/1/16.
 */
public class MyArbitraryType {

    public boolean receivingInstanceMethod(String string) {
        System.out.println("Inside the receiving @Arbitary Type method ..... ");
        return true;
    }

    public static boolean receivingStaticMethod(String string) {
        System.out.println("Inside the receiving @Arbitary Type method ..... ");
        return true;
    }
}
