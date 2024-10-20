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




    // all test will be testing for the 'happy path' we will implement error handling later in development.
    
}
