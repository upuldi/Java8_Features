package com.java8.demo.streams.flatMap;

import java.util.List;

/**
 * Created by L078878 on 17/02/2017.
 */
public class Parent {

    private String parentField;
    private List<Child> childList;

    public String getParentField() {
        return parentField;
    }

    public void setParentField(String parentField) {
        this.parentField = parentField;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public Parent(String parentField) {
        this.parentField = parentField;
    }
}
