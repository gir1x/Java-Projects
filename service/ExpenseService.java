package service;

import java.util.ArrayList;
import model.Expense;
import model.User;

public class ExpenseService {

    private ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public double getTotalExpense() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.calculateExpense();
        }
        return total;
    }

    public void checkBudget(User user) {
        if (user.getMonthlyBudget() > 0 &&
            getTotalExpense() > user.getMonthlyBudget()) {
            System.out.println("⚠ Budget exceeded!");
        }
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }
}
