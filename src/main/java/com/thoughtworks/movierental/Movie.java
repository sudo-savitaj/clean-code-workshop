package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

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

    boolean isNewRelease() {
        return priceCode == NEW_RELEASE;
    }

    double amount(int daysRented) {
        switch (priceCode) {
            case REGULAR:
                return amountForRegularMovie(daysRented);
            case NEW_RELEASE:
                return amountForNewReleaseMovie(daysRented);
            case CHILDRENS:
                return amountForChildren(daysRented);
            default:
                return amountForUnknownMovie();
        }
    }

    private double amountForUnknownMovie() {
        return 0d;
    }

    private double amountForChildren(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }

    private double amountForNewReleaseMovie(int daysRented) {
        return daysRented * 3;
    }

    private double amountForRegularMovie(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }

    boolean isBonusApplicable(int daysRented) {
        return isNewRelease() && daysRented > 1;
    }

    int frequentRenterPoint(int daysRented) {
        if (isBonusApplicable(daysRented))
            return 2;
        return 1;
    }
}
