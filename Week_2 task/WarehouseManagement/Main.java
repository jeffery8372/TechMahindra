import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Initializing inventory
        inventoryManager.addProduct(new Product("P001", "Laptop", 5, new Location(1, 1, 1)));
        inventoryManager.addProduct(new Product("P002", "Phone", 3, new Location(1, 2, 2)));
        inventoryManager.addProduct(new Product("P003", "Tablet", 2, new Location(2, 1, 3)));

        // Creating orders
        Order order1 = new Order("O001", Arrays.asList("P001", "P002"), Order.Priority.STANDARD);
        Order order2 = new Order("O002", Arrays.asList("P002", "P003"), Order.Priority.EXPEDITED);
        Order order3 = new Order("O003", Arrays.asList("P001"), Order.Priority.STANDARD);

        // Placing orders
        inventoryManager.placeOrder(order1);
        inventoryManager.placeOrder(order2);
        inventoryManager.placeOrder(order3);

        // Processing orders concurrently
        inventoryManager.processOrders();

        // Displaying remaining inventory
        inventoryManager.printInventory();
    }
}
