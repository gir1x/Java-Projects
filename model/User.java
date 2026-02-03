package model;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private double monthlyBudget;

    public User(String name) {
        this.name = name;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }
}
