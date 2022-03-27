/*
Class used for generating the basic drawn components of the Jframe Truck_Map. Components can be added in various
methods and then added to paint() in other to be drawn on the JFrame.
 */

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TruckMap extends Panel {
    public Truck truck;
    public ServiceCenter serviceCenter;

    /*
    Draws the basic gridlines on the JFrame, which are used to position addresses
     */
    void drawLines(Graphics g) {

        // Vertical Streets
        for(int x = 1; x <= 1001; x = x + 100)
            g.drawLine(x, 0, x, 1000);

        // Horizontal Streets
        for(int y = 0; y <= 1000; y = y + 100)
            g.drawLine(0, y, 1000, y);
    }

    /**
     * creates the service center and a basic truck to check if movement works
     */
    public void createRepresentations() {
        Location location = new Location(500, 500);

        // call readBatchFile() and assign to ArrayList orders
        ArrayList<Order> orders = readBatchFile();

        // instantiate new strategy (can choose to either prioritize distance or the time of the order)
        RouteStrategy strategy = new TimeStrategy();
        PriorityQueue<Order> queue = strategy.createRoute(orders);

        LinkedList<Location> destinations = new LinkedList<>();
        for (int i = 0; i < queue.size(); i++) {
            Location destination = queue.poll().convertToLocation();
            destinations.add(destination);
            System.out.println(destination);
        }

        // call convertOrdersToLocations(orders) and assign to destinations

        truck = new Truck(location, destinations, strategy);
        serviceCenter = new ServiceCenter();
    }

    /**
     * Calls TruckDot's update so that TruckSim does not need to deal with the TruckDot class
     */
    public void update() {
        truck.update();
    }

    /*
    Method used to control the drawing components on the JFrame
     */
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
        truck.paintComponent(g);
        serviceCenter.paintComponent(g);
    }


    public boolean truckHasOrders(){
        return truck.hasDestinations();
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

        Order order = new Order(address, timeStamp);
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
}