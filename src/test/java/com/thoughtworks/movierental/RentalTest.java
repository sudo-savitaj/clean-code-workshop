package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest {

    @Test
    public void shouldCalculateAmountForRegularMovie() {
        Rental rental = new Rental(new Movie("movie-1", new RegularMovieType()), 10);
        assertEquals(14d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateFrequentRenterPointForRegularMovie() {
        Rental rental = new Rental(new Movie("movie-1", new RegularMovieType()), 10);
        assertEquals(1d, rental.frequentRenterPoint(), 0d);
    }

    @Test
    public void shouldCalculateAmountForChildrenMovie() {
        Rental rental = new Rental(new Movie("movie-1", new ChildrenMovieType()), 10);
        assertEquals(12d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateFrequentRenterPointForChildrenMovie() {
        Rental rental = new Rental(new Movie("movie-1", new ChildrenMovieType()), 10);
        assertEquals(1d, rental.frequentRenterPoint(), 0d);
    }

    @Test
    public void shouldCalculateAmountForNewReleaseMovie() {
        Rental rental = new Rental(new Movie("movie-1", new NewReleaseMovieType()), 10);
        assertEquals(30d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateFrequentRenterPointForNewReleaseMovie() {
        Rental rental = new Rental(new Movie("movie-1", new NewReleaseMovieType()), 10);
        assertEquals(2d, rental.frequentRenterPoint(), 0d);
    }

    @Test
    public void shouldCalculateAmountForUnknownMovie() {
        Rental rental = new Rental(new Movie("movie-1", new NULLMovieType()), 10);
        assertEquals(0d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateFrequentRenterPointForUnknownMovie() {
        Rental rental = new Rental(new Movie("movie-1", new NULLMovieType()), 10);
        assertEquals(1d, rental.frequentRenterPoint(), 0d);
    }

    @Test
    public void shouldCalculateAmountForBlueRayMovie() {
        Rental rental = new Rental(new Movie("movie-1", new BlueRayMovieType()), 10);
        assertEquals(40d, rental.amount(), 0d);
    }

    @Test
    public void shouldCalculateFrequentRenterPointForBlueRayMovie() {
        Rental rental = new Rental(new Movie("movie-1", new BlueRayMovieType()), 10);
        assertEquals(3d, rental.frequentRenterPoint(), 0d);
    }
}
