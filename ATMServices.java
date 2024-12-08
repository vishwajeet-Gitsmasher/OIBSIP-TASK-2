package Source;

public class ATMServices {

    public static void displayTransactionHistory(int id) {
        int userIndex = User.getUserIndexById(id);
        if (userIndex == -1) {
            System.out.println("Invalid User ID.");
            return;
        }

        System.out.println("Transaction History:");
        for (Transaction t : User.transactionHistories[userIndex]) {
            System.out.println(t);
        }
    }

    public static void withdrawATM(int id, double amount) {
        int userIndex = User.getUserIndexById(id);
        if (userIndex == -1 || amount <= 0) {
            System.out.println("Invalid User ID or Amount.");
            return;
        }

        if (amount > User.users[userIndex][2]) {
            System.out.println("Insufficient funds.");
            return;
        }

        User.users[userIndex][2] -= amount;
        System.out.println("Withdrawal successful: " + amount + " Rupees");
        System.out.println("Account Balance: " + User.users[userIndex][2]);
        User.transactionHistories[userIndex].add(new Transaction("Withdrawal", amount, User.users[userIndex][2]));
    }

    public static void depositATM(int id, double amount) {
        int userIndex = User.getUserIndexById(id);
        if (userIndex == -1 || amount <= 0) {
            System.out.println("Invalid User ID or Amount.");
            return;
        }

        User.users[userIndex][2] += amount;
        System.out.println("Deposit successful: " + amount + " Rupees");
        System.out.println("Account Balance: " + User.users[userIndex][2]);
        User.transactionHistories[userIndex].add(new Transaction("Deposit", amount, User.users[userIndex][2]));
    }

    public static void transferATM(int senderId, int receiverId, double amount) {
        int senderIndex = User.getUserIndexById(senderId);
        int receiverIndex = User.getUserIndexById(receiverId);

        if (senderIndex == -1 || receiverIndex == -1 || amount <= 0) {
            System.out.println("Invalid User ID(s) or Amount.");
            return;
        }

        if (amount > User.users[senderIndex][2]) {
            System.out.println("Insufficient funds.");
            return;
        }

        User.users[senderIndex][2] -= amount;
        User.users[receiverIndex][2] += amount;

        System.out.println("Transfer Successful: " + amount + " Rupees");
        System.out.println("Sender Account Balance: " + User.users[senderIndex][2]);
        System.out.println("Receiver Account Balance: " + User.users[receiverIndex][2]);

        User.transactionHistories[senderIndex].add(new Transaction("Transfer Out", amount, User.users[senderIndex][2]));
        User.transactionHistories[receiverIndex].add(new Transaction("Transfer In", amount, User.users[receiverIndex][2]));
    }
}
