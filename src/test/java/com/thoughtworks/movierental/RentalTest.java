package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    @Test
    public void shouldCalculateAmountForRegularMovie() {
        Rental rental = new Rental(new Movie("movie-1", new RegularMovieType()), 10);
        assertEquals(14d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateAmountForChildrenMovie() {
        Rental rental = new Rental(new Movie("movie-1", new ChildrenMovieType()), 10);
        assertEquals(12d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateAmountForNewReleaseMovie() {
        Rental rental = new Rental(new Movie("movie-1", new NewReleaseMovieType()), 10);
        assertEquals(30d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateAmountForUnknownMovie() {
        Rental rental = new Rental(new Movie("movie-1", new NULLMovieType()), 10);
        assertEquals(0d, rental.amount(), 0d);
    }
}
