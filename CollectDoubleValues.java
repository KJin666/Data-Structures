import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CollectDoubleValues {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        final int MAX_NUMBERS = 20;
        final double TERMINATION_VALUE = 99999.0;

        System.out.println("Enter up to 20 double values. Type 99999 to quit.");

        while (numbers.size() < MAX_NUMBERS) {
            System.out.print("Enter a double value: ");

            // input
            if (!scanner.hasNextDouble()) {
                String input = scanner.next();
                System.out.println("Invalid input. Please enter a double value.");
                continue; // go into next loop
            }

            double value = scanner.nextDouble();

            if (value == TERMINATION_VALUE) {
                break; // out
            }

            numbers.add(value);
        }

        if (numbers.isEmpty()) {
            System.out.println("No numbers were entered.");
        } else {
            System.out.println("You entered the following numbers:");
            for (double number : numbers) {
                System.out.println(number);
            }
        }

        scanner.close();
    }
}
