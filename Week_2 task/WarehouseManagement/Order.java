import java.util.*;

class Order implements Comparable<Order> {
    enum Priority{ 
        STANDARD, 
        EXPEDITED 
    };

    private String orderID;
    private List<String> productIDs;
    private Priority priority;

    public Order(String orderID, List<String> productIDs, Priority priority){
        this.orderID = orderID;
        this.productIDs = productIDs;
        this.priority = priority;
    }

    public String getOrderID(){ 
        return orderID; 
    }
    public List<String> getProductIDs(){ 
        return productIDs; 
    }
    public Priority getPriority(){ 
        return priority; 
    }

    @Override
    public int compareTo(Order other){
        return this.priority.compareTo(other.priority);
    }

    @Override
    public String toString(){
        return "Order " + orderID + " (Priority: " + priority + ")";
    }
}
