/*
This class represents the address of a location on a grid. The house number can be anywhere from 100 - 990 and has
to be even. The street can be a street from A - J or 1-10.

Author: Jacob Smith
 */
public class Address {

    private int houseNumber;
    private String street;

    public Address(int houseNumber, String street) {
        if (isValidHouseNumber(houseNumber)) {
            this.houseNumber = houseNumber;
        }
        else {
            this.houseNumber = 0;
        }

        if (isValidStreet(street)) {
            this.street = street;
        }
        else {
            this.street = "Void";
        }
    }

    public int getHouseNumber() {
        return this.houseNumber;
    }

    public String getStreet() {
        return this.street;
    }

    private boolean isValidStreet(String street) {
        return true;
    }

    private boolean isValidHouseNumber(int houseNumber) {
        return (houseNumber < 991 && houseNumber > 99 && houseNumber % 2 == 0);
    }
}
