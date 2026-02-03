package model;

public class TravelExpense extends Expense {

    public TravelExpense(double amount, String date) {
        super(amount, "Travel", date);
    }

    @Override
    public double calculateExpense() {
        return amount;
    }
}
