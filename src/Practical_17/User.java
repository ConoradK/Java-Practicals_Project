package Practical_17;
//the following class is part of the practical 17 package


public class User {

    //this main method is where all the process for manipulating orders and inventory systems
    public static void main(String[] args) {

        //both inventory 1 and 2 are created
        InventorySystem inventorySystem1 = new InventorySystem();
        InventorySystem inventorySystem2 = new InventorySystem();

        //below all orders are created
        Order order1 = new Order("1", "Product A", 10.0, 3);
        Order order2 = new Order("2", "Product B", 15.8, 2);
        Order order3 = new Order("3", "Product C", 20.0, 1);
        Order order4 = new Order("4", "Product D", 10.35, 3);
        Order order5 = new Order("5", "Product E", 15.0, 8);
        Order order6 = new Order("6", "Product F", 5.99, 9);
        Order order7 = new Order("7", "Product G", 10.0, 6);
        Order order8 = new Order("8", "Product H", 13.5, 7);
        Order order9 = new Order("9", "Product I", 38.0, 2);

        //all actions on inventory system 1 is performed below
        inventorySystem1.placeOrder(order1);
        inventorySystem1.placeOrder(order2);
        inventorySystem1.updateOrder(order1,Order.Status.Paid);
        inventorySystem1.cancelOrder("2");
        inventorySystem1.trackOrder("1");
        inventorySystem1.placeOrder(order7);
        inventorySystem1.updateOrder(order7,Order.Status.Paid);
        inventorySystem1.placeOrder(order9);
        inventorySystem1.cancelOrder("10");
        inventorySystem1.updateOrder(order7,Order.Status.Delivered);


        //below all orders in inventory system 1
        // with specified Status are displayed
        inventorySystem1.printOrdersWithStatus(Order.Status.Paid);




        //all actions on inventory system 2 is performed below
        inventorySystem2.placeOrder(order3);
        inventorySystem2.placeOrder(order8);
        inventorySystem2.updateOrder(order3,Order.Status.Paid);
        inventorySystem2.updateOrder(order3,Order.Status.Delivered);
        inventorySystem2.updateOrder(order3,Order.Status.Refunded);
        inventorySystem2.placeOrder(order4);
        inventorySystem2.cancelOrder("8");


        //below all orders in inventory system 2
        // with specified Status are displayed
        inventorySystem2.printOrdersWithStatus(Order.Status.Refunded);




        // the Total revenue for inventory system 1 and 2 are displayed
        System.out.println("Total Revenue for Inventory System 1: £" + inventorySystem1.calculateTotalRevenue());
        System.out.println("Total Revenue for Inventory System 2: £" + inventorySystem2.calculateTotalRevenue());
    }
}
