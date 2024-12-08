package Source;

import java.util.ArrayList;

public class User {
    static int[][] users = {{1, 1705, 1000}, {2, 1234, 2000}, {3, 5678, 5000}};
    public static ArrayList<Transaction>[] transactionHistories = new ArrayList[users.length];

    static {
        for (int i = 0; i < transactionHistories.length; i++) {
            transactionHistories[i] = new ArrayList<>();
        }
    }

    public static boolean validateUser(int id, int pin) {
        for (int[] user : users) {
            if (user[0] == id && user[1] == pin) {
                return true;
            }
        }
        return false;
    }

    public static int getUserIndexById(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i][0] == id) {
                return i;
            }
        }
        return -1;
    }
}
