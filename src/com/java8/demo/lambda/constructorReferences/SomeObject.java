package com.java8.demo.lambda.constructorReferences;

/**
 * Created by udoluweera on 8/1/16.
 */
public class SomeObject {

    int x;
    String y;

    public SomeObject(int x, String y) {
        this.x = x;
        this.y = y;
    }

    public SomeObject(int x) {
        this.x = x;
    }
}
