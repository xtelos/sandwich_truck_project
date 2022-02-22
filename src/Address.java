/*
This class represents the address of a location on a grid. The house number can be anywhere from 100 - 990 and has
to be even. The street can be a street from A - J or 1-10.

Author: Jacob Smith
 */
public class Address {

    private final int houseNumber;
    private final String street;

    /**
     * Address Constructor which validates the information given, if the address is not valid the
     * house number will be assigned as 0 and the street will be 'Void'. Does not return anything
     *
     * @param houseNumber: (int) represents the house number for the house on the street
     * @param street: (String) represents the street that the house is on
     *
     * Author: Jacob Smith
     */
    public Address(int houseNumber, String street) {
        if (isValidHouseNumber(houseNumber)) {
            this.houseNumber = houseNumber;
        }
        else {
            this.houseNumber = 0;
        }

        if (isValidStreet(street)) {
            this.street = street.toUpperCase();
        }
        else {
            this.street = "Void";
        }
    }

    /**
     * Getter for the user to obtain the house number for the address, returns an integer
     *
     * @return houseNumber: (int)
     *
     * Author: Jacob Smith
     */
    public int getHouseNumber() {
        return this.houseNumber;
    }

    /**
     * Getter for the user to obtain the street for the address, returns a String
     *
     * @return street: (String)
     *
     * Author: Jacob Smith
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * Private method that tells the constructor whether the information given is a valid street for the Address
     *
     * @param street: (String)
     * @return: (boolean)
     *
     * Author: Jacob Smith
     */
    private boolean isValidStreet(String street) {
        try {
            int streetInt = Integer.parseInt(street);
            return streetInt < 11 && streetInt > 0;
        }
        catch (NumberFormatException e) {
            char streetLetter = street.charAt(0);
            streetLetter = Character.toUpperCase(streetLetter);
            return streetLetter >= 'A' && streetLetter <= 'J';
        }

    }

    /**
     * Private method that tells the constructor whether the information given is a valid houseNumber for the Address
     *
     * @param houseNumber: (int)
     * @return: (boolean)
     *
     * Author: Jacob Smith
     */
    private boolean isValidHouseNumber(int houseNumber) {
        return (houseNumber < 991 && houseNumber > 99 && houseNumber % 2 == 0);
    }
}
