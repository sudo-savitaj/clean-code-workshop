package com.thoughtworks.movierental;

public class ChildrenMovieType extends MovieType {
    @Override
    public int priceCode() {
        return Movie.CHILDRENS;
    }
}
