import java.util.HashMap;

public class Order {

    private Address address;
    private TimeStamp timeStamp;

    public Order(Address address, TimeStamp timeStamp) {
        this.address = address;
        this.timeStamp = timeStamp;
    }

    public Address getAddress() {
        return this.address;
    }

    public TimeStamp getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public String toString() {
        return address.toString() + "," + timeStamp.toString();
    }

    /**
     * Converts each order's address into Locations that the JFrame is able to use
     * @return: LinkedList of destinations for the JFrame to use
     *
     * Author: Jacob Smith
     */
    public Location convertToLocation() {
        Location location;

        String street = address.getStreet();
        int houseNumber = address.getHouseNumber();

        try {
            int convertedStreet = Integer.parseInt(street);
            convertedStreet *= 100;
            location = new Location(houseNumber, convertedStreet);
        }
        catch (NumberFormatException e) {
            int convertedStreet = convertStreetToInteger(street);
            location = new Location(convertedStreet, houseNumber);
        }
        return location;
    }

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
