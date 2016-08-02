package com.java8.demo.functions.consumer;

import java.util.function.Consumer;

/**
 * Created by udoluweera on 8/2/16.
 */
public class ConsumerDemo {

    /**
     * Consumers takes and input and produces nothing.
     * Any functionality like persisting/deleting records notifying something are candidates for consumers.
     */

    //This is the structure of the Java Consumer Interface.
    interface ConsumerDemoInterface<T> {
        void accept(T t);
    }

    // A consumer to display the movie name
    Consumer<Movie> printMovieDetails = (m) -> System.out.println(" Name : " +  m.getName() + " and Rating : " + m.getRating());

    //To persist a movie to the DB
    Consumer<Movie> persistMovieToDatabase = this::persistMovieToDB;

    public void consumerTest(Movie movie) {
        printMovieDetails.accept(movie);
        persistMovieToDatabase.accept(movie);
    }

    /**
     * Consumers can be integrated using methods in the consumer class as follows.
     */
    public void printAndSaveMovieToDB(Movie movie) {
        System.out.println("**** AND THEN TEST ****");
        printMovieDetails.andThen(persistMovieToDatabase).accept(movie);
    }

    public void persistMovieToDB(Movie movie) {
        System.out.println("Persisting a movie  to the DB....." + movie.getName());
    }

    public static void main(String[] args) {
        Movie movie = new ConsumerDemo().new Movie("300",8);
        new ConsumerDemo().consumerTest(movie);
        new ConsumerDemo().printAndSaveMovieToDB(movie);
    }

    class Movie {

        String name;
        int rating;

        public Movie(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }
}
