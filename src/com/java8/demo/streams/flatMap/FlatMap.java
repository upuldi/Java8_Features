package com.java8.demo.streams.flatMap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by L078878 on 17/02/2017.
 */
public class FlatMap {

    public static void main(String[] args) {

        /**
         * Used to transform one object into many other objects or vise versa
         *
         * FlatMap convert a each object in an stream into a stream of other objects
         * So each object will be transformed into a zero one or many objects in other stream
         */

        //Creation
        List<Parent> parentObjectsList = createParentsObjects();

        parentObjectsList.stream().//With flatMap this stream will be converted into a child objects stream
                flatMap(p -> p.getChildList().stream()). //Converting parents stream into child stream
                forEach(c -> System.out.println(c.getChildField()));

        //From the parent stream
        Stream<Child> childStream = parentObjectsList.stream().
                flatMap(p -> p.getChildList().stream());

        sameThingInOneOperation();
    }

    private static void sameThingInOneOperation() {

        IntStream.rangeClosed(1, 5).
                mapToObj(i -> new Parent("Parent Object " + i)).
                peek(FlatMap::getParentConsumer). //This is a best practice, When you have multiline lambds move them into the static methods
                flatMap(p -> p.getChildList().stream()).
                forEach(c -> System.out.println("Single Method : " + c.getChildField()));
    }

    private static Parent getParentConsumer(Parent p) {
        List<Child> childrenList = new ArrayList<Child>();
        IntStream.rangeClosed(1, 5).mapToObj(i -> new Child("I am " + i + " child of " + p.getParentField())).
                forEach(c -> childrenList.add(c));
        p.setChildList(childrenList);
        return p;
    }

    private static List<Parent> createParentsObjects() {

        List<Parent> parents = new ArrayList<>();

        //Add parents based on a int stream
        IntStream.rangeClosed(1, 5).
                forEach(i -> parents.add(new Parent(" Parent Object " + i)));

        //Add children to parents
        parents.stream().
                forEach(p -> {
                    List<Child> childList = new ArrayList<Child>();
                    childList.add(new Child("i Am a Child object of " + p.getParentField()));
                    p.setChildList(childList);
                });

        return parents;
    }
}
