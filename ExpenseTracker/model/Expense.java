package model;

import java.io.Serializable;

public abstract class Expense implements Serializable {

    protected double amount;
    protected String category;
    protected String date;

    public Expense(double amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public abstract double calculateExpense();

    @Override
    public String toString() {
        return date + " | " + category + " | ₹" + amount;
    }
}
