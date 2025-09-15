package pack1;

import java.util.Scanner;

public class Pizza_Billing_System {
    private String size;
    private int basePrice;
    private String addPepperoni;
    private String addCheese;
    private int pepperoniPrice;
    private int cheesePrice;
    private int totalBill;

    public Pizza_Billing_System() {
        basePrice = 0;
        pepperoniPrice = 0;
        cheesePrice = 20;   // default, only added if selected
        totalBill = 0;
    }

    public void pizzaSize() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter pizza size (S = Small, M = Medium, L = Large): ");
            size = sc.nextLine();

            if (size.equalsIgnoreCase("S")) {
                basePrice = 100;
                break;
            } else if (size.equalsIgnoreCase("M")) {
                basePrice = 200;
                break;
            } else if (size.equalsIgnoreCase("L")) {
                basePrice = 300;
                break;
            } else {
                System.out.println("Invalid size! Try again.");
            }
        }
    }

    public void pizzaToppings() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want pepperoni? (Y/N): ");
        addPepperoni = sc.nextLine();

        if (addPepperoni.equalsIgnoreCase("Y")) {
            if (size.equalsIgnoreCase("S")) {
                pepperoniPrice = 30;
            } else {
                pepperoniPrice = 50;
            }
        }

        System.out.print("Do you want extra cheese? (Yes/No): ");
        addCheese = sc.nextLine();

        if (!addCheese.equalsIgnoreCase("Yes")) {
            cheesePrice = 0;
        }
    }

    public void totalBill() {
        totalBill = basePrice + pepperoniPrice + cheesePrice;
    }

    public void showBill() {
        System.out.println("\n--- Pizza Order Details ---");
        System.out.println(" Price: " + basePrice);
        System.out.println("Pepperoni: " + pepperoniPrice);
        System.out.println("Cheese: " + cheesePrice);
        System.out.println("Total Bill = " + totalBill);
    }
}
