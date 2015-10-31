package com.tw;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }



    public String statement() {
        int frequentRenterPoints = getFrequentRentelPoints();
        double totalAmount = getTotalAmount();
        String result = getResult();
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

    private int getFrequentRentelPoints() {
        int frequentRenterPoints = 0;
        for (Rental each: _rentals) {
            frequentRenterPoints = each.incrementFrequentRenterPoints(frequentRenterPoints);
        }
        return frequentRenterPoints;
    }


    private double getTotalAmount(){
        double totalAmount = 0;
        for (Rental each: _rentals) {
            totalAmount += each.GetRentalAmount();
        }
        return totalAmount;
    }

    private String getResult(){
        String result = "Rental Record for " + _name + "\n";
        for (Rental each: _rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.GetRentalAmount()) + "\n";
        }
        return result;
    }



}
