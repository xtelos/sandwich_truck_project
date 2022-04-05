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
    public RedHouse redHouse;

    /**
     * creates the service center and a basic truck to check if movement works
     */
    TruckMap() {
        Location location = new Location(500, 500);

        ArrayList<Order> orders = readBatchFile();

        RouteStrategy timeStrategy = new TimeStrategy();
        RouteStrategy distanceStrategy = new DistanceStrategy();

        PriorityQueue<Order> queue = distanceStrategy.createRoute(orders);

        LinkedList<Location> destinations = new LinkedList<>();
        LinkedList<Location> houses = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Location destination = queue.poll().convertToLocation();
            destinations.add(destination);
            houses.add(destination);
        }
        destinations.add(new Location(500, 500));

        truck = new Truck(location, destinations, distanceStrategy);
        serviceCenter = new ServiceCenter();
        redHouse = new RedHouse(houses);
    }

    /**
     * Calls TruckDot's update so that TruckSim does not need to deal with the TruckDot class
     */
    public void update() {
        if (truck.location.equals(redHouse.location))
        {
            redHouse.update();
        }
        truck.update();

    }


    void drawNeighborhood(Graphics g) {

    /*
    Draws the basic gridlines on the JFrame, which are used to position addresses
     */

        // Vertical Streets
        for(int x = 1; x <= 1001; x = x + 100)
            g.drawLine(x, 0, x, 1000);

        // Horizontal Streets
        for(int y = 0; y <= 1000; y = y + 100)
            g.drawLine(0, y, 1000, y);
    }

    /*
    Method used to control the drawing components on the JFrame
     */
    public void paint(Graphics g) {
        super.paint(g);
        drawNeighborhood(g);
        redHouse.paintComponent(g);
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
//590 400
//400 590
//500 640
//        600 600
//        600 600 ?
//        600 400 ?
//        600 400 ?
// 380 400
//        300 500
//        300 500 ?
// 300 520
// 470 300
//        300 600
//        300 600 ?
// 600 700
//
//        500 800
//        500 800 ?
// 300 480
// 800 470
// 300 730
// 810 500
// 500 180
// 250 300
// 200 620
// 500 170
// 400 180
// 400 820
//
//        700 800
//        700 800
//        300 800
//        300 800
//        200 770
//        200 220
//        140 700
//        700 860
//        860 700
//        800 210
//        800 200
//        800 200
//        920 600
//        900 680
//        900 700
//        900 700
//        700 900
//        700 900
//        870 200
//        100 780
//        110 200
//        210 100
//        800 100
//        100 800
//        1000 560
//        910 800
//        700 970
//        100 820
//        1000 620
//        200 920
//        200 950
//        130 100
//        1000 730
//        900 120
//        960 100
//        1000 870
//        1000 900
//        1000 900
