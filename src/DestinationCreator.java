import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DestinationCreator {

    public DestinationCreator()
    {

    }

    public void createDestinations(LinkedList<Location> destinations, RouteStrategy strategy){
        ArrayList<Order> orders = readBatchFile();
        PriorityQueue<Order> queue = strategy.createRoute(orders);
        for (int i = 0; i < 100; i++) {
            Location destination = queue.poll().convertToLocation();
            destinations.add(destination);
        }
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

        Order order = new Order(address, timeStamp, new Turkey());
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