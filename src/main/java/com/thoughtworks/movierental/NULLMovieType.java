package com.thoughtworks.movierental;

public class NULLMovieType extends MovieType {
    @Override
    public int priceCode() {
        return -1;
    }

    @Override
    public double amountFor(int daysRented) {
        return 0;
    }
}
