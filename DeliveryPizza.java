public class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    // Constructor for DeliveryPizza class
    public DeliveryPizza(String[] toppings, int numberOfToppings, String deliveryAddress) {
        // superclass (Pizza)
        super(toppings, numberOfToppings);
        // Set the delivery address in programing
        this.deliveryAddress = deliveryAddress;

        // Calculate delivery fee (pizza price)
        this.deliveryFee = super.getPrice() > 18 ? 3 : 5;
    }

    //custom string representation
    @Override
    public String toString() {
        // Return  string representation of the pizza including delivery details and total price
        return super.toString() + " Delivered to: " + deliveryAddress + ". Total price: $" + (super.getPrice() + deliveryFee);
    }
}
