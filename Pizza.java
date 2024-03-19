public class Pizza {
    private String[] toppings;
    private double price;

    // Constructor for Pizza class
    public Pizza(String[] toppings, int numberOfToppings) {
        this.toppings = new String[10];
        // Copy the toppings from the input array to the instance variable array
        System.arraycopy(toppings, 0, this.toppings, 0, numberOfToppings);

        // Build a description of the pizza with toppings
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < numberOfToppings; i++) {
            description.append(toppings[i]);
            if (i < numberOfToppings - 1) {
                description.append(", ");
            }
        }

        // Calculate the price of the pizza based on the number of toppings
        this.price = 14 + 2 * numberOfToppings;
    }

    // Method to get the price of pizza
    public double getPrice() {
        return price;
    }

    public String toString() {
        // Return a string representation of the pizza including toppings and price
        return "Pizza with " + String.join(", ", toppings) + ". Price: $" + price;
    }
}
