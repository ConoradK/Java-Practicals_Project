package Practical_17;
//class Order is part of package 17


////this class is responsible for the structure of the object of type Order
class Order {

    //the Status of class enum is declared and its values are shown within it
    //outside the Order class to access the enum Status
    // it must be referred as Order.Status.
    enum Status{Pending,Paid,Shipped,Delivered,Refunded}

    private String orderId;
    //the attribute order id is declared and has a default null
    private String productName;
    //the attribute productName is declared and has a default null
    private double productPrice;
    //the attribute productPrice is declared and has a default 0.0d
    private int quantity;
    //the attribute quantity is declared and has a default 0
    private Status status;
    //private Status status;
    //the attribute status is declared and has a default null


    //this constructor takes in the argument values of all attributes of the Order class
    //but only the status variable is kept not part of the arguments as all default transactions begin
    //as a pending process of a payment
    public Order(String orderId, String productName, double productPrice, int quantity) {

        this.orderId = orderId;

        this.productName = productName;

        this.productPrice = productPrice;

        this.quantity = quantity;

        //status has an initial value of Pending.
        this.status = Status.Pending;

    }


    public String getOrderId() {
        return orderId;
    }
    //this get method returns the order id of an order

    public String getProductName() {
        return productName;
    }
    //this get method returns the product name of an order

    public double getProductPrice() {
        return productPrice;
    }
    //this get method returns the price of a product

    public int getQuantity() {
        return quantity;
    }
    //this get method returns the quantity of the products of an order

    public Status getStatus() {
        return status;
    }
    //this get method returns the status of an order


    public void setStatus(Status status) {
        this.status = status;
    }
    //this set method updates the status of an order


    //this toString method has been overridden, it displays all  attributes of the order
    //in a user-friendly manner
    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Product Name: " + productName +
                ", Product Price: £" + productPrice +
                ", Quantity: " + quantity +
                ", Status: " + status;
    }
}
