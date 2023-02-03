package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return header() + body() + footer();
    }

    private String footer() {
        String footer = "Amount owed is " + totalAmount() + "\n";
        footer += "You earned " + totalFrequentRenterPoint()
                + " frequent renter points";
        return footer;
    }

    private String body() {
        String body = "";
        for (Rental rental : rentals) {
            body += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return body;
    }

    private String header() {
        return  "Rental Record for " + getName() + "\n";
    }

    private int totalFrequentRenterPoint() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoint();
        }
        return frequentRenterPoints;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();;
        }
        return totalAmount;
    }

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h3>Rental Record for " + name + "<h3>";
    }

    private String htmlBody() {
        String result = "<p>";
        for (Rental each : rentals) {
            result += each.getMovie().getTitle() + "<b>" +
                    each.amount() + "</b><br/>";
        }
        result += "</p>";
        return result;
    }

    private String htmlFooter() {
        return "<p>Amount owed is <b> " + totalAmount() +" </b></p><p>You earned <b> " + totalFrequentRenterPoint() + "</b> frequent renter points</p>";
    }
}

