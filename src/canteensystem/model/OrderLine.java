package canteensystem.model;

public class OrderLine {
    private int orderID;
    private String name;
    private int quantity;
    private double price;
   private String table;
    private String date;

    public OrderLine(int orderID, String name, int quantity, double price, String table, String date) {
        this.orderID = orderID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.table = table;
        this.date = date;
    }
  public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  
}
