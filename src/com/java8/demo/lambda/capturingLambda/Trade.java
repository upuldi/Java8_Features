package com.java8.demo.lambda.capturingLambda;

/**
 * Created by udoluweera on 8/1/16.
 */
public class Trade {

    private String name;
    private Integer value;
    private Boolean started;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public Trade(String name, Integer value, Boolean started) {
        this.name = name;
        this.value = value;
        this.started = started;
    }
}
