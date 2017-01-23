package com.java8.demo.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by udoluweera on 8/8/16.
 */
public class StreamsFunctions {

    List<Movie> moviesList = Arrays.asList(new Movie("300",4),new Movie("ET",3), new Movie("LOTR",5), new Movie("AVP",2));

    private void findHighestRatedMovies() {
        moviesList.stream().
                filter((m)-> m.getRating()>3?true:false).
                /*Here we have to give a function to the map method. (m) -> m.getName() */
                map(Movie::getName).
                distinct().
                /* Here we are providing a consumer (m) -> Sop(m)*/
                forEach(System.out::println);
    }

    public static void main(String[] args) {}

    class Movie {
        String name;
        int rating;

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

        public Movie(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }
}
