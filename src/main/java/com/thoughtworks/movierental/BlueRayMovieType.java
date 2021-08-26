package com.thoughtworks.movierental;

public class BlueRayMovieType extends MovieType {
    @Override
    public int priceCode() {
        return Movie.BLUE_RAY;
    }

    @Override
    public double amountFor(int daysRented) {
        return daysRented * 4;
    }
}
