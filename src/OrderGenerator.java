/*
This class generates 100 random Address objects and saves their data to a batch file

Author: Jacob Smith
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class OrderGenerator
{
    private final ArrayList<Address> addressBook;

    public OrderGenerator() {
        addressBook = new ArrayList<>(1000);
    }

    /**
     * Generates a random address that is on a Letter Street (any street that has a letter for the name)
     *
     * @param numStreets: (int) number of addresses to generate
     *
     * Author: Jacob Smith
     */
    private void generateLetterStreetAddress(int numStreets) {
        Random random = new Random();
        for (int i = 0; i < numStreets; i++) {
            char c = (char) ('a' + random.nextInt(10));
            String street = String.valueOf(c);
            int houseNum = (random.nextInt(98) + 1) * 10;
            if (houseNum < 100) {
                houseNum *= 10;
            }
            writeAddressToFile(street, houseNum);
        }
    }

    /**
     * Generates a random address that is on a Number Street (any street that has a number for the name)
     *
     * @param numStreets: (int) number of addresses to generate
     *
     * Author: Jacob Smith
     */
    private void generateNumberStreetAddress(int numStreets) {
        Random random = new Random();
        for (int i = 0; i < numStreets; i++) {
            int integer = random.nextInt(8) + 1;
            String street = String.valueOf(integer);
            int houseNum = (random.nextInt(98) + 1) * 10;
            if (houseNum < 100) {
                houseNum *= 10;
            }
            writeAddressToFile(street, houseNum);
        }
    }

    private void writeAddressToFile(String street, int houseNum) {
        Address address = new Address(houseNum, street);
        addressBook.add(address);
        String timeStamp = generateTimeStamp();
        writeToFile(address, timeStamp);
    }

    /**
     * Generates a time stamp for the order that goes along with an address
     *
     * Author: Jacob Smith
     */
    private String generateTimeStamp() {
        Random random = new Random();
        int hours = random.nextInt(11) + 1;
        int minutes = random.nextInt(60);
        return hours + ":" + minutes;
    }

    /**
     * Writes the given address and time stamp to a file named orders.txt
     *
     * @param address: (Address) object that represents an address
     * @param timeStamp: (String) represents the time stamp in hours and minutes
     *
     * Author: Jacob Smith
     */
    private void writeToFile(Address address, String timeStamp) {
        try {
            File file = new File("orders.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(address.getHouseNumber() + " " + address.getStreet() + " Street, " + timeStamp + "\n");
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("Could not open file");
            e.printStackTrace();
        }
    }

    /**
     * Generates an even number of Letter Street Addresses as Number Street Addresses
     *
     * @param numAddress: (int) total number of addresses generated
     *
     * Author: Jacob Smith
     */
    public void generate(int numAddress) {
        generateLetterStreetAddress(numAddress / 2);
        generateNumberStreetAddress(numAddress / 2);
    }

}