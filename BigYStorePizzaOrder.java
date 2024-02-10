import java.util.Scanner;

public class BigYStorePizzaOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to BigY Store Pizza Ordering!");
        System.out.println("Sizes: Small ($5), Medium ($10), Large ($15), Super ($20)");
        System.out.print("Choose your size: ");
        String choice = scanner.nextLine().toLowerCase();

        int basePrice = switch (choice) {
            case "small" -> 5;
            case "medium" -> 10;
            case "large" -> 15;
            case "super" -> 20;
            default -> -1; // Invalid choice
        };

        if (basePrice == -1) {
            System.out.println("Invalid size. Please restart the application.");
            return;
        }

        System.out.println("Each topping is $0.50, 3 for $1.25. How many toppings would you like to add?");
        int toppingCount = scanner.nextInt();
        double toppingPrice = calculateToppingPrice(toppingCount);

        double totalPrice = basePrice + toppingPrice;

        System.out.println("\nOrder Summary:");
        System.out.println("Size: " + choice + " ($" + basePrice + ")");
        System.out.println("Toppings: " + toppingCount + " ($" + toppingPrice + ")");
        System.out.println("Total: $" + totalPrice);
        System.out.println("Thank you for your order!");
    }

    private static double calculateToppingPrice(int count) {
        if (count == 3) {
            return 1.25;
        } else {
            return count * 0.50;
        }
    }
}
