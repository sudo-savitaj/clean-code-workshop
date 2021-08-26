package com.thoughtworks.movierental;

public class ChildrenMovieType extends MovieType {
    @Override
    public int priceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double amountFor(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }
}
