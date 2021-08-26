package com.thoughtworks.movierental;

public abstract class MovieType {
    public abstract int priceCode();
    public abstract double amountFor(int daysRented);
    public abstract int frequentRenterPointFor(int daysRented);
}
