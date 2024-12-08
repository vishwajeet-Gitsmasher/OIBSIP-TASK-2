package Source;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcme To Bank ATM Services");
        while (true) {
            System.out.println("1. User Login");
            System.out.println("2. Exit");
            System.out.print("Enter Your Choice: ");
            
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }
            
            int c = sc.nextInt();

            if (c == 1) {
                System.out.print("Enter User ID: ");
                int id = sc.nextInt();
                System.out.print("Enter User PIN: ");
                int pin = sc.nextInt();

                boolean isUserValid = User.validateUser(id, pin);

                if (isUserValid) {
                    boolean quit = false;

                    while (!quit) {
                        System.out.println("\n1. Transactions History");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Deposit");
                        System.out.println("4. Transfer");
                        System.out.println("5. Quit");
                        System.out.print("Enter Your Choice: ");

                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            sc.next();
                            continue;
                        }

                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                ATMServices.displayTransactionHistory(id);
                                break;

                            case 2:
                                System.out.print("Enter amount for withdrawal: ");
                                double wamount = sc.nextDouble();
                                ATMServices.withdrawATM(id, wamount);
                                break;

                            case 3:
                                System.out.print("Enter amount for deposit: ");
                                double damount = sc.nextDouble();
                                ATMServices.depositATM(id, damount);
                                break;

                            case 4:
                                System.out.print("Enter amount for transfer: ");
                                double amount = sc.nextDouble();
                                System.out.print("Enter receiver Account ID for transfer: ");
                                int rid = sc.nextInt();
                                ATMServices.transferATM(id, rid, amount);
                                break;

                            case 5:
                                System.out.println("Thank you for using ATM Services!");
                                quit = true;
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                } else {
                    System.out.println("Invalid User ID or PIN. Please try again.");
                }
            } else if (c == 2) {
                System.out.println("Exiting... Thank you for using ATM Services!");
                sc.close();
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}