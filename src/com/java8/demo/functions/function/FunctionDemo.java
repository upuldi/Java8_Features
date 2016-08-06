package com.java8.demo.functions.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by udoluweera on 8/6/16.
 */
public class FunctionDemo {

    /**
     * This is how the function interface looks like.
     */
    public interface FunctionDemoInterface<T,R> {
        R apply(T t);
    }


    private void testAFunctionCall() {

        Function<String,Movie> createAMovieByName = (n) -> new Movie(n);
        Function<String,Movie> createAMovieByNameWithConstructorRef = Movie::new;

        Movie movie = createAMovieByName.apply("Reverent");
        Movie movie2 = createAMovieByNameWithConstructorRef.apply("MI3");

        System.out.println(createAMovieByName.apply("Avatar").getName());
    }

    private void findMovie(String name) {

        Supplier<List<Movie>> movieSupplier = () -> Arrays.asList(new Movie("AVP"),new Movie("Ring"),new Movie("Saw"));

        Function<String,Movie> findMoviesByName = (s) -> {
            for(Movie m : movieSupplier.get()) {
                if (m.getName().equals(s)) return m;
            }
            return null;
        };

        Movie returnedMovie = findMoviesByName.apply(name);
        System.out.println("Found movie : " + returnedMovie.getName());
    }

    public static void main(String[] args) {

        new FunctionDemo().testAFunctionCall();
        new FunctionDemo().findMovie("Ring");

    }


    class Movie {

        String name;

        public Movie(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
