package model;

public class FoodExpense extends Expense {

    public FoodExpense(double amount, String date) {
        super(amount, "Food", date);
    }

    @Override
    public double calculateExpense() {
        return amount;
    }
}
