package com.thoughtworks.movierental;

import java.util.List;

class Statement {

    private final String name;
    private final List<Rental> rentals;
    private final double totalAmount;
    private final int totalFrequentRenterPoint;

    public Statement(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoint) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoint = totalFrequentRenterPoint;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoint
                + " frequent renter points";
        return result;
    }
}
