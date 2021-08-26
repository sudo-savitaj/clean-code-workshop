package com.thoughtworks.movierental;

public class RegularMovieType extends MovieType {
    @Override
    public int priceCode() {
        return Movie.REGULAR;
    }
}
