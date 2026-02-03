import java.util.Scanner;
import model.*;
import service.ExpenseService;
import util.FileUtil;
import exception.InvalidExpenseException;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseService service = new ExpenseService();

        System.out.print("Enter your name: ");
        User user = new User(sc.nextLine());

        Object[] data = FileUtil.loadData();
        if (data != null) {
            service.setExpenses((java.util.ArrayList<Expense>) data[0]);
            user = (User) data[1];
            System.out.println("Previous data loaded.");
        }

        while (true) {
            System.out.println("\n1. Add Food Expense");
            System.out.println("2. Add Travel Expense");
            System.out.println("3. View Expenses");
            System.out.println("4. Set Budget");
            System.out.println("5. View Total");
            System.out.println("6. Exit");

            int choice = safeInt(sc);

            try {
                switch (choice) {
                    case 1:
                        addExpense(sc, service, "Food");
                        service.checkBudget(user);
                        break;

                    case 2:
                        addExpense(sc, service, "Travel");
                        service.checkBudget(user);
                        break;

                    case 3:
                        service.viewExpenses();
                        break;

                    case 4:
                        System.out.print("Enter monthly budget: ");
                        user.setMonthlyBudget(safeDouble(sc));
                        break;

                    case 5:
                        System.out.println("Total: ₹" + service.getTotalExpense());
                        break;

                    case 6:
                        FileUtil.saveData(service.getExpenses(), user);
                        System.out.println("Data saved. Bye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid option");
                }
            } catch (InvalidExpenseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addExpense(Scanner sc, ExpenseService service, String type)
            throws InvalidExpenseException {

        System.out.print("Enter amount: ");
        double amount = safeDouble(sc);

        if (amount <= 0)
            throw new InvalidExpenseException("Amount must be positive");

        Expense expense = type.equals("Food")
                ? new FoodExpense(amount, "Today")
                : new TravelExpense(amount, "Today");

        service.addExpense(expense);
        System.out.println("Expense added.");
    }

    private static int safeInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Enter a number: ");
        }
        return sc.nextInt();
    }

    private static double safeDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.print("Enter a valid amount: ");
        }
        return sc.nextDouble();
    }
}
