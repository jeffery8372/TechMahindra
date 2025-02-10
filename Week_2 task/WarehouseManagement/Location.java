class Location{
    private int aisle, shelf, bin;

    public Location(int aisle, int shelf, int bin){
        this.aisle = aisle;
        this.bin = bin;
        this.shelf = shelf;

    }

    @Override
    public String toString(){
        return "Aisle " + aisle + ", Shelf " + shelf + ", Bin " + bin;
    }
}

class Product{
    private String productID, name;
    private int quantity;
    private Location location;

    public Product(String productID, String name, int quantity, Location location){
        this.quantity = quantity;
        this.productID = productID;
        this.location = location;
        this.name = name;
    }

    public String getProductID(){
         return productID;
    }
    public String getName(){ 
        return name; 
    }
    public int getQuantity(){ 
        return quantity; 
    }
    public Location getLocation(){ 
        return location; 
    }

    public void reduceQuantity(int amount) throws OutOfStockException{
        if (amount > quantity){
            throw new OutOfStockException("Not enough stock for " + name);
        }
        quantity -= amount;
    }

    @Override
    public String toString(){
        return name + " (ID: " + productID + ", Qty: " + quantity + ", Location: " + location + ")";
    }
}
