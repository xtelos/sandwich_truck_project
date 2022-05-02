/*
Class to represent an order. It has two data members that is the Address for the order and the TimeStamp
for when the order was placed. Can also be converted into a Location object

Author: Jacob Smith
 */

import java.util.HashMap;

public class Order {

    private Address address;
    private TimeStamp timeStamp;
    private Sandwich sandwich;

    /**
     * Instantiates an Order containing the address of the order, the timestamp of the order, and the sandwich of the order
     * @param address
     * @param timeStamp
     * @param sandwich
     */
    public Order(Address address, TimeStamp timeStamp, Sandwich sandwich) {
        this.address = address;
        this.timeStamp = timeStamp;
        this.sandwich = sandwich;
    }

    /**
     * Gives the address of the order
     * @return: Address for order
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Gives the time the order was made
     * @return: TimeStamp for order
     */
    public TimeStamp getTimeStamp() {
        return this.timeStamp;
    }

    /**
     * Gives the type of sandwich ordered
     * @return: Sandwich for order
     */
    public Sandwich getSandwich(){
        return this.sandwich;
    }

    /**
     * Returns the Order description
     * @return String
     */
    @Override
    public String toString() {
        return address.toString() + "," + timeStamp.toString() + "," + sandwich.getDescription();
    }

    /**
     * Converts each order's address into Locations that the JFrame is able to use
     * @return: LinkedList of destinations for the JFrame to use
     *
     * Author: Jacob Smith
     */
    public Location convertToLocation() {
        Location location;
        int convertedStreet;

        String street = address.getStreet();
        int houseNumber = address.getHouseNumber();

        try {
            convertedStreet = Integer.parseInt(street) * 100;
            location = new Location(houseNumber, convertedStreet);
        }
        catch (NumberFormatException e) {
            convertedStreet = convertStreetToInteger(street);
            location = new Location(convertedStreet, houseNumber);
        }
        return location;
    }

    /**
     * Converts a street with a letter as the name into an integer for the JFrame to be able to use
     * @param street: String of the street name
     * @return: integer value associated with the street name
     */
    private int convertStreetToInteger(String street) {
        HashMap<String, Integer> conversions = new HashMap<>();
        conversions.put("A", 100);
        conversions.put("B", 200);
        conversions.put("C", 300);
        conversions.put("D", 400);
        conversions.put("E", 500);
        conversions.put("F", 600);
        conversions.put("G", 700);
        conversions.put("H", 800);
        conversions.put("I", 900);
        conversions.put("J", 1000);

        return conversions.get(street);
    }



}
