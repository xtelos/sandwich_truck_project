/*
Tests for the Address Class

Author: Jacob Smith
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressTests {

    @Test
    public void testAddressBookCreatesAddress() {
        Address address = new Address(110, "7");

        assertEquals(110, address.getHouseNumber());
        assertEquals("7", address.getStreet());
    }

    @Test
    public void testHouseNumberIsOutOfRange() {
        Address address = new Address(1000, "1");

        assertEquals(0, address.getHouseNumber());
        assertEquals("1", address.getStreet());
    }

    @Test
    public void testStreetNotAtoJLetter() {
        Address address = new Address(110, "L");

        assertEquals(110, address.getHouseNumber());
        assertEquals("Void", address.getStreet());
    }

}
