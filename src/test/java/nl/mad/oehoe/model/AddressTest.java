package nl.mad.oehoe.model;

import static org.junit.Assert.assertEquals;
import nl.mad.model.Address;

import org.junit.Test;

public class AddressTest {

    @Test
    public void constructAddress() {
        Address address = new Address();
        address.setAddressId(0);
        address.setAddressType("Type");
        address.setCity("City");
        address.setCountry("Country");
        address.setPostcode("Postcode");
        address.setState("State");
        address.setStreet("Street");
        assertEquals("Id is not the same, ", 0, address.getAddressId());
        assertEquals("Type is not the same, ", "Type", address.getAddressType());
        assertEquals("City is not the same, ", "City", address.getCity());
        assertEquals("Country is not the same, ", "Country", address.getCountry());
        assertEquals("Postcode is not the same, ", "Postcode", address.getPostcode());
        assertEquals("State is not the same, ", "State", address.getState());
        assertEquals("Street is not the same, ", "Street", address.getStreet());
    }

}
