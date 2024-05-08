package Practical_17;
//class Order is part of package 17

import java.util.HashMap;
//this library contains all methods from the HashMap library
import java.util.Map;
//this library contains all methods from the Map library


//this class is responsible for containing and manipulating the orders(order list)
public class InventorySystem {

    //this hash map ,that is of type Map that takes in
    // type String for the key and type Order for the value,
    //is declared
    private Map<String, Order> orders = new HashMap<>();

    //this method adds an order to the order hash map
    //and the parameter takes in an order that is of type Order
    public void placeOrder(Order order) {
        //the put method adds or updates the order in the has map
        //the order is accessed via the order id and then the value of the key is the order
        orders.put(order.getOrderId(), order);
    }

    //this method is responsible for updating the order's status that is within the hashmap
    public void updateOrder(Order order,Order.Status status) {
        // the order's status is updated via the set method
        order.setStatus(status);
        //however the change done to the actual order doesn't update the value of the order
        // in the orders hash map
        //thus, the same instruction is performed like in update Order method
        orders.put(order.getOrderId(), order);
    }

    //this method is responsible for removing the selected order from the hash map
    //the parameter is the order id of the order
    public void cancelOrder(String orderId) {
        //this if statement checks is the order id is located as one of the keys in the orders hash map
        if(orders.containsKey(orderId)) {
            //if yes then the key and the value of the key is removed from the hash map
            orders.remove(orderId);
        }
        //otherwise a reply is returned telling the user that the key of the given order id was not found
        else{
            System.out.println("order with order id: "+orderId+" is not found in the inventory system");
        }
    }

    //this method displays the status of the order
    //the parameter is the order id of the order
    public void trackOrder(String orderId) {
        //this if statement checks whether the returned value from the hash function,
        // with order id as the parameter,
        // is the same as the key in the hash map
        if(orders.containsKey(orderId)) {
            //if yes then the order's statistics are retrieved using the id and are displayed using the toString method
            System.out.println("Tracked Order: " + orders.get(orderId)+"\n");
        }
        //otherwise a reply is returned telling the user that the key of the given order id was not found
        else{
            System.out.println("order with order id: "+orderId+" is not found in the inventory system\n");
        }
    }

    //this method displays all orders with a desired status within the orders hash map
    //the status of the required order is passed as the argument
    public void printOrdersWithStatus(Order.Status status) {
        //message displayed telling the user what to expect
        System.out.println("Orders with status " + status + ":");
        //a for loop is used to iterate through every value in the hash map
        for (Order order : orders.values()) {
            //an if statement that checks whether the current status
            // of the value in the hash map is equal to the desired status

            //if (order.getStatus().equals(status)) {
            if (order.getStatus().equals(status)) {
                //if so then the full detail about the order is displayed
                System.out.println(order);
            }
        }
        System.out.println("\n");
    }

    //this method returns a double value of the total revenue
    public double calculateTotalRevenue() {
        //the total revenue is set to null
        double totalRevenue = 0;
        //a for loop is used to iterate through every value in the hash map
        for (Order order : orders.values()) {
            //then the current value has its product and price per product retrieved
            //the calculation is performed and is added to the total
            totalRevenue += order.getProductPrice() * order.getQuantity();
        }
        return totalRevenue;
    }
}


