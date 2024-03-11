import java.util.ArrayList;
import java.util.List;

// Defines a grocery item with a name, price, and description
class Item {
    private String name;
    private double price;
    private String description; // Additional detail about the item

    public Item(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
// manage an order of a specific item, including quantity and bulk pricing options

class ItemOrder {
    private Item item;
    private int quantity;
    private double bulkPrice; // Price for bulk quantity
    private int bulkQuantity; // min quantity needed to qualify for bulk pricing

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // set bulk pricing details
    public void setBulkPricing(double bulkPrice, int bulkQuantity) {
        this.bulkPrice = bulkPrice;
        this.bulkQuantity = bulkQuantity;
    }

    // calculate price based on bulk pricing
    public double getPrice() {
        if (bulkPrice > 0 && quantity >= bulkQuantity) {
            int bulkSets = quantity / bulkQuantity;
            int remainingItems = quantity % bulkQuantity;
            return (bulkSets * bulkPrice) + (remainingItems * item.getPrice());
        }
        return quantity * item.getPrice();
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

// represents a shopping cart containing multiple item orders.
class ShoppingCart {
    private List<ItemOrder> orders;

    public ShoppingCart() {
        orders = new ArrayList<>();
    }

    //add a new item order to the shopping cart
    public void addItemOrder(ItemOrder order) {
        orders.add(order);
    }
    //removes an item order form the cart based on the name
    public void removeItemOrder(String itemName) {
        orders.removeIf(order -> order.getItem().getName().equals(itemName));
    }
    //update the quantity of an existing item order in the cart
    public void updateItemOrder(String itemName, int newQuantity) {
        for (ItemOrder order : orders) {
            if (order.getItem().getName().equals(itemName)) {
                order.updateQuantity(newQuantity);
                break;
            }
        }
    }
    //calculates and returns the total price of all item orders in the cart
    public double getTotalPrice() {
        return orders.stream().mapToDouble(ItemOrder::getPrice).sum();
    }
}
