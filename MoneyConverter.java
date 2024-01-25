import java.util.Scanner;

public class MoneyConverter
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        double amount = scanner.nextDouble();
        scanner.close();

        int cents = (int) (amount * 100);
        System.out.println("Total cents: " + cents);
        int quarters = calculateQuarters(cents);
        cents -= quarters * 25;
        int dimes = calculateDimes(cents);
        cents -= dimes * 10;
        int nickels = calculateNickels(cents);

        System.out.println("Quarters needed: " + quarters);
        System.out.println("Dimes needed: " + dimes);
        System.out.println("Nickels needed: " + nickels);
    }

    private static int calculateQuarters(int cents) {
        return cents / 25;
    }

    private static int calculateDimes(int cents) {
        return cents / 10;
    }

    private static int calculateNickels(int cents) {
        return cents / 5;
    }
}
