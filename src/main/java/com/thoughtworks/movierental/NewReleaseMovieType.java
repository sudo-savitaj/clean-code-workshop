package com.thoughtworks.movierental;

public class NewReleaseMovieType extends MovieType {
    @Override
    public int priceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double amountFor(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int frequentRenterPointFor(int daysRented) {
        if (daysRented > 1){
            return 2;
        }
        return 1;
    }
}
