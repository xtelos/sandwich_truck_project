/*
Class used for generating the basic drawn components of the Jframe Truck_Map. Components can be added in various
methods and then added to paint() in other to be drawn on the JFrame.
 */

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Truck_Map extends Panel {
    public TruckDot truck;
    public ServiceCenterDot serviceCenter;

    /*
    Draws the basic gridlines on the JFrame, which are used to position addresses
     */
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Vertical Streets
        g2d.drawLine(100, 0, 100, 1000);
        g2d.drawLine(200, 0, 200, 1000);
        g2d.drawLine(300, 0, 300, 1000);
        g2d.drawLine(400, 0, 400, 1000);
        g2d.drawLine(500, 0, 500, 1000);
        g2d.drawLine(600, 0, 600, 1000);
        g2d.drawLine(700, 0, 700, 1000);
        g2d.drawLine(800, 0, 800, 1000);
        g2d.drawLine(900, 0, 900, 1000);
        g2d.drawLine(1000, 0, 1000, 1000);

        // Horizontal Streets
        g2d.drawLine(0, 100, 1000, 100);
        g2d.drawLine(0, 200, 1000, 200);
        g2d.drawLine(0, 300, 1000, 300);
        g2d.drawLine(0, 400, 1000, 400);
        g2d.drawLine(0, 500, 1000, 500);
        g2d.drawLine(0, 600, 1000, 600);
        g2d.drawLine(0, 700, 1000, 700);
        g2d.drawLine(0, 800, 1000, 800);
        g2d.drawLine(0, 900, 1000, 900);
        g2d.drawLine(0, 1000, 1000, 1000);

    }


    /**
     * creates the service center and a basic truck to check if movement works
     */
    public void createRepresentations() {
        Location location = new Location(500, 500);

        // Just examples, replace with actual addresses for houses
//        Location destination1 = new Location(600, 500);
//        Location destination2 = new Location(600, 600);
//
//        LinkedList<Location> destinations = new LinkedList<>();
//        destinations.add(destination1);
//        destinations.add(destination2);


        // call readBatchFile() and assign to ArrayList orders
        ArrayList<Order> orders = readBatchFile();

        // instantiate new strategy (can choose to either prioritize distance or the time of the order)
        RouteStrategy strategy = new DistanceStrategy();
        PriorityQueue<Location> queue = strategy.createRoute(orders);

        LinkedList<Location> destinations = new LinkedList<>();
        for (int i = 0; i < queue.size(); i++) {
            destinations.add(queue.poll());
        }

        // call convertOrdersToLocations(orders) and assign to destinations

        truck = new TruckDot(location, destinations, strategy);
        serviceCenter = new ServiceCenterDot();
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
        serviceCenter.paint(g);
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
                String line = scanner.nextLine();
                String[] data = line.split(",");

                // Creates new Address object
                String addressInfo = data[0];
                int houseNumber = Integer.parseInt(addressInfo.substring(0, 3));
                String street = addressInfo.substring(4, 5);
                Address address = new Address(houseNumber, street);

                // Creates new TimeStamp object
                String[] timeStampInfo = data[1].split(":");
                int hours = Integer.parseInt(timeStampInfo[0]);
                int minutes = Integer.parseInt(timeStampInfo[1]);
                TimeStamp timeStamp = new TimeStamp(hours, minutes);

                Order order = new Order(address, timeStamp);
                orders.add(order);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Couldn't read file");
        }
        return orders;
    }
}