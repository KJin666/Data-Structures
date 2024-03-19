import java.util.Scanner;

public class DemoPizza {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Initialize an array to store pizza toppings
        String[] toppings = new String[10];
        int count = 0;

        // Prompt the user to enter toppings until they enter "quit" or reach the limit
        System.out.println("Enter your toppings (type quit to stop):");
        while (count < 10) {
            // Read user input
            String input = scanner.nextLine();
            // Check if the user wants to quit
            if ("QUIT".equalsIgnoreCase(input)) {
                break;
            }
            // Store the topping and increment the count
            toppings[count++] = input;
        }

        // Ask whether the pizza is to be delivered
        System.out.println("Is this pizza to be delivered? (yes/no):");
        String delivery = scanner.nextLine();

        // If the pizza is to be delivered
        if ("yes".equalsIgnoreCase(delivery)) {
            System.out.println("Enter delivery address:");
            String address = scanner.nextLine();
            DeliveryPizza pizza = new DeliveryPizza(toppings, count, address);
            // Print the details of the delivery pizza
            System.out.println(pizza);
        } else {
            Pizza pizza = new Pizza(toppings, count);
            System.out.println(pizza);
        }

        // Close the scanner
        scanner.close();
    }
}
