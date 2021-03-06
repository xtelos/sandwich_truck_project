import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DestinationCreator {

    public LinkedList<String> sandwichOrders = new LinkedList<>();
    /**
     * creates list of destinations for the route
     * @param destinations
     * @param strategy
     */
    public void createDestinations(LinkedList<Location> destinations, RouteStrategy strategy){
        ArrayList<Order> orders = readBatchFile();
        PriorityQueue<Order> queue = strategy.createRoute(orders);
        for(Order order: queue)
        {
            sandwichOrders.add(order.getSandwich().getDescription());
        }
        int temp = queue.size() - 100;
        for (int i = 0; i < temp + 100; i++) {
            Location destination = queue.poll().convertToLocation();
            destinations.add(destination);
        }
    }

    /**
     * Getter for sandwichOrders
     * @return list of sandwiches
     */
    public LinkedList<String> getSandwichOrders()
    {
        return sandwichOrders;
    }


    /**
     * Reads the batchfile containing the 100 orders and returns them in a collection
     *
     * @return: ArrayList<Order> of all the orders read from file in no order
     * <p>
     * Author: Jacob Smith
     */
    private ArrayList<Order> readBatchFile() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            File file = new File("orders.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                addOrder(orders, scanner);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Couldn't read file");
        }
        return orders;
    }

    /**
     * reads file, gets address and time stamp, then adds the order to the order list
     * @param orders
     * @param scanner
     */
    private void addOrder(ArrayList<Order> orders, Scanner scanner) {
        String line = scanner.nextLine();
        String[] data = line.split(",");

        Address address = getAddress(data[0]);
        TimeStamp timeStamp = getTimeStamp(data[1]);
        Sandwich sandwich = getSandwich(data[2]);

        Order order = new Order(address, timeStamp, sandwich);
        orders.add(order);
    }


    /**
     * creates a time stamp object
     * @param datum
     * @return
     */
    private TimeStamp getTimeStamp(String datum) {
        String[] timeStampInfo = datum.split(":");
        int hours = Integer.parseInt(timeStampInfo[0]);
        int minutes = Integer.parseInt(timeStampInfo[1]);
        return new TimeStamp(hours, minutes);
    }

    /**
     * creates a address object
     * @param addressInfo
     * @return
     */
    private Address getAddress(String addressInfo) {
        int houseNumber = Integer.parseInt(addressInfo.substring(0, 3));
        String street = addressInfo.substring(4, 5);
        return new Address(houseNumber, street);
    }

    /**
     * creates a sandwich object, defaulting to a very simple hamburger if sandwichInfo is unrecognized by the method
     * @param sandwichInfo
     * @return
     */
    private Sandwich getSandwich(String sandwichInfo){

        Sandwich newSandwich;

        if(sandwichInfo.equals("Ham Sandwich"))
        {
            newSandwich = new Ham();
            newSandwich = new Bread(newSandwich);
            newSandwich = new Cheese(newSandwich);
            newSandwich = new Mayonnaise(newSandwich);
        }
        else if(sandwichInfo.equals("Hamburger"))
        {
            newSandwich = new Hamburger();
            newSandwich = new Bun(newSandwich);
            newSandwich = new Cheese(newSandwich);
            newSandwich = new Lettuce(newSandwich);
            newSandwich = new Tomato(newSandwich);
            newSandwich = new Ketchup(newSandwich);
        }
        else if (sandwichInfo.equals("Turkey Sandwich"))
        {
            newSandwich = new Turkey();
            newSandwich = new Bread(newSandwich);
            newSandwich = new Cheese(newSandwich);
            newSandwich = new Mustard(newSandwich);
        }
        else
        {
            newSandwich = new Hamburger();
            newSandwich = new Bun(newSandwich);
            newSandwich = new Cheese(newSandwich);
        }

        return newSandwich;

    }
}