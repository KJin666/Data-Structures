import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank", "Ivy", "John"};
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter an index to display a name (0-9): ");
                int index = scanner.nextInt();
                System.out.println("Name at position " + index + " is: " + names[index]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Index is out of bounds. Please try again.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
