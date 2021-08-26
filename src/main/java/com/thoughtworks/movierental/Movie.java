package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int BLUE_RAY = 3;

    private String title;
    private int priceCode;
    private MovieType movieType;

    @Deprecated
    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        this.movieType = getMovieTypeFor(priceCode);
    }

    private MovieType getMovieTypeFor(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                return new RegularMovieType();
            case NEW_RELEASE:
                return new NewReleaseMovieType();
            case CHILDRENS:
                return new ChildrenMovieType();
            default:
                return new NULLMovieType();
        }
    }

    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.priceCode = movieType.priceCode();
        this.movieType = movieType;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    public double amount(int daysRented) {
        return movieType.amountFor(daysRented);
    }

    public int frequentRenterPoint(int daysRented) {
        return movieType.frequentRenterPointFor(daysRented);
    }

    private boolean isBonusApplicable(int daysRented) {
        return isNewRelease() && daysRented > 1;
    }

    private boolean isNewRelease() {
        return priceCode == NEW_RELEASE;
    }
}
