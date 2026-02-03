package util;

import java.io.*;
import java.util.ArrayList;
import model.Expense;
import model.User;

public class FileUtil {

    private static final String FILE_NAME = "expense_data.ser";

    public static void saveData(ArrayList<Expense> expenses, User user) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(expenses);
            oos.writeObject(user);
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    @SuppressWarnings("unchecked")
    public static Object[] loadData() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ArrayList<Expense> expenses =
                    (ArrayList<Expense>) ois.readObject();
            User user = (User) ois.readObject();
            return new Object[]{expenses, user};
        } catch (Exception e) {
            return null;
        }
    }
}
