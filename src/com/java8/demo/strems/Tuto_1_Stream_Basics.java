package streams;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Tuto_1_Stream_Basics {

    public static void main(String[] args) {

        //Streams represent sequence of elements
        //And support different kind of operations on them

        //Stream operations are either intermediate or terminal
        //Intermediate : returns a stream eg : filter() map() sorted()
        //Terminal : Return a void or Non Stream result eg:forEach()

        // Streams can be created from collections
        Stream<String> stream = Arrays.asList("A", "B", "C", "D", "E", "F").stream();
        stream.findFirst().ifPresent(System.out::println);

        //You can create strems using new API
        //You can create strems using new API
        Stream<String> streamFromAPI = Stream.of("A", "B", "C", "D", "E", "F");

        System.out.println("\nInt Streams");

        //For primitive data types there are Primitive Streams
        IntStream.range(1,4).forEach(System.out::println);

        System.out.println("\nSpecial methods in Int Streams sum() and average() ");

        /**
         * The main difference between Primitive and Object Streams are
         *
         * 1.) Use specialised functions - IntFunction and IntPredicate instead of Function and Predicate
         * 2.) Contains additional methods - like sum() and average()
         */

        IntStream.rangeClosed(1,5).map(x -> 2 * x+1).average().ifPresent(System.out::println);

        System.out.println("\n\nTransforming an Object Stream in to a Integer Stream....");

        /* You can transform an Object stream into a primitive stream and vise versa using mapToInt(), maptToLong() and mapToDouble() */
        Stream.of("A1","A2","A3","A4").map(s -> s.substring(1)).mapToInt(Integer::parseInt).forEach(System.out::println);


        System.out.println("\n\nTransforming primitive stream into a Object stream");

        /* You can transform back a primitive stream into an object stream using mapToObject() */
        IntStream.rangeClosed(1,5).mapToObj(x -> "A" + x).forEach(System.out::println);

        System.out.println("\nProcessing order");

        //Intermediate Operations are lazy and they only get executed only when the terminal operation is present.
        Stream.of("a","b","c","d").filter(s -> {
            System.out.println("filter" + s);
            return true;
        } );

        //The above statement doesn't get executed as there is no terminal operation at the stream

        Stream.of("a","b","c","d").filter(s -> {
            System.out.println("filter : " + s);
            return true;
        } ).forEach(System.out::println);

        //Here each element moves along the chain vertically

        //http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/




    }

}
