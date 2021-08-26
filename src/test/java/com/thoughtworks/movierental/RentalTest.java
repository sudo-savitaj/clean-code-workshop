package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    @Test
    public void shouldCalculateAmountForRegularMovie() {
        Rental rental = new Rental(new Movie("movie-1", Movie.REGULAR), 10);
        assertEquals(14d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateAmountForChildrenMovie() {
        Rental rental = new Rental(new Movie("movie-1", Movie.CHILDRENS), 10);
        assertEquals(12d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateAmountForNewReleaseMovie() {
        Rental rental = new Rental(new Movie("movie-1", Movie.NEW_RELEASE), 10);
        assertEquals(30d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateAmountForUnknownMovie() {
        Rental rental = new Rental(new Movie("movie-1", 4), 10);
        assertEquals(0d, rental.amount(), 0d);
    }
}
