package com.thoughtworks.movierental;

import java.util.List;

class HTMLStatement {

    private final String name;
    private final List<Rental> rentals;
    private final double totalAmount;
    private final int totalFrequentRenterPoint;

    public HTMLStatement(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoint) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoint = totalFrequentRenterPoint;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h3>Rental Record for " + name + "<h3>";
    }

    private String htmlBody() {
        String result = "<p>";
        for (Rental rental : rentals) {
            result += rental.getMovie().getTitle() + "<b>" +
                    rental.amount() + "</b><br/>";
        }
        result += "</p>";
        return result;
    }

    private String htmlFooter() {
        return "<p>Total amount "+ totalAmount +" You earned <b> " + totalFrequentRenterPoint + "</b> frequent renter points</p>";
    }
}
