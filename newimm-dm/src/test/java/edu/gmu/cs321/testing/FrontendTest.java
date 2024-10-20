package edu.gmu.cs321.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.gmu.cs321.frontend.*;
/**
 * Will test the following classes
 * AddressComponent
 * DOBComponent
 * EntryPoint
 * NameComponent
 */
public class FrontendTest {
    AddressComponent addressComponent = new AddressComponent();
    addressComponent.setAddress("4400 University Dr, Fairfax, VA 22030");  // George Mason University address
    addressComponent.setZipcode(22030);
    addressComponent.setCountry("USA");
    addressComponent.setState("VA");


    String address = addressComponent.getAddress();
    int zipcode = addressComponent.getZipcode();
    String country = addressComponent.getCountry();
    String state = addressComponent.getState();

    assertEquals("4400 University Dr, Fairfax, VA 22030", address, "Expected George Mason University address but got " + address);
    assertEquals(22030, zipcode, "Expected 22030 but got " + zipcode);
    assertEquals("USA", country, "Expected USA but got " + country);
    assertEquals("VA", state, "Expected VA but got " + state);


    @Test // start with entry test
    public void entryPointStatusTest() {
        // Test the status field in EntryPoint class.
        EntryPoint entryPoint = new EntryPoint();
        entryPoint.setStatus(true);  // Setting status to true so for like a good input.

        boolean status = entryPoint.getStatus();

        assertTrue(status, "Expected true status but got false");
    }

    @Test
    public void nameComponentSetterGetterTest() {
        // Test the setter and getter methods for name fields.
        NameComponent nameComponent = new NameComponent();
        nameComponent.setFirstName("Jesh");
        nameComponent.setLastName("Anthony");  // Setting name to Jesh Anthony

        String firstName = nameComponent.getFirstName();
        String lastName = nameComponent.getLastName();

        assertEquals("Jesh", firstName, "Expected first name Jesh but got " + firstName);
        assertEquals("Anthony", lastName, "Expected last name Anthony but got " + lastName);
        entryPoint.setStatus(false);
        result = entryPoint.submitApplication();
        assertFalse(result, "Expected submission to fail, but it was successful.");
    }

    






    // all test will be testing for the 'happy path' we will implement error handling later in development.
    
}
