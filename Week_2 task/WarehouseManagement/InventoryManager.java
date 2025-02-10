import java.util.*;
import java.util.concurrent.*;

class InventoryManager{
    private Map<String,Product> inventory = new ConcurrentHashMap<>();
    private PriorityQueue<Order> orderQueue = new PriorityQueue<>(Collections.reverseOrder());

    public void addProduct(Product product){
        inventory.put(product.getProductID(), product);
    }

    public void placeOrder(Order order){
        synchronized (orderQueue) {
            orderQueue.add(order);
        }
    }

    public void processOrders(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        while (!orderQueue.isEmpty()){
            Order order;
            synchronized (orderQueue) {
                order = orderQueue.poll();
            }
            if (order != null){
                executor.execute(() -> fulfillOrder(order));
            }
        }
        executor.shutdown();
    }

    private void fulfillOrder(Order order){
        System.out.println("Processing " + order);
        for (String productID : order.getProductIDs()){
            Product product = inventory.get(productID);
            if (product != null){
                try {
                    product.reduceQuantity(1);
                    System.out.println("Fulfilled " + product.getName() + " for Order " + order.getOrderID());
                } 
                catch (OutOfStockException e){
                    System.err.println("Order " + order.getOrderID() + " failed: " + e.getMessage());
                }
            } 
            else{
                System.err.println("Order " + order.getOrderID() + " failed: Product " + productID + " not found.");
            }
        }
    }

    public void printInventory(){
        System.out.println("Current Inventory:");
        inventory.values().forEach(System.out::println);
    }
}
