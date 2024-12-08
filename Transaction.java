package Source;

import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private double balanceAfterTransaction;
    private Date date;

    public Transaction(String type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return date + " | " + type + " | Amount: " + amount + " | Balance: " + balanceAfterTransaction;
    }
}
