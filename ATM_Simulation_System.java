package minipro1;

import java.util.Scanner;

public class ATM_Simulation_System {

    private final String Predefined_PIN = "1234";
    private int balance;

    public void checkPassword() {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.print("Enter PIN: ");
            String passwordEntered = sc.next();

            if (passwordEntered.equals(Predefined_PIN)) {
                System.out.println("Login successful!");
                while (count < 3) {
                    System.out.println("Menu: ");
                    System.out.println(" a) Deposit ");
                    System.out.println(" b) Withdraw ");
                    System.out.println(" c) Check Balance ");
                    System.out.println(" d) Exit ");
                    System.out.print("Enter choice: ");
                    String choice = sc.next().toLowerCase();

                    if (choice.equals("a")) {
                        System.out.print("Enter amount to deposit: ");
                        int amount = sc.nextInt();
                        deposit(amount);
                    } else if (choice.equals("b")) {
                        System.out.print("Enter amount to withdraw: ");
                        int amount = sc.nextInt();
                        withdraw(amount);
                    } else if (choice.equals("c")) {
                        checkBalance();
                    } else if (choice.equals("d")) {
                        exit();
                    } else {
                        System.out.println("Invalid choice, try again!");
                        continue;
                    }
                }
            } else {
                count++;
                if (count == 3) {
                    System.out.println("ATM Locked!");
                    break;
                }
            }
        }
    }

    public void deposit(int m) {
        if (m > 0) {
            balance += m;
            System.out.println("Deposited: " + m);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(int m) {
        if (m > 0 && m <= balance) {
            balance -= m;
            System.out.println("Withdrew: " + m);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Balance = " + balance);
    }

    public void exit() {
        System.out.println("Exiting... Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        ATM_Simulation_System atm = new ATM_Simulation_System();
        atm.checkPassword();
    }
}
