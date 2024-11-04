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
    }
    // next for date of birth

    @Test
    public void dobComponentSetterGetterTest() {
       
        DOBComponent dobComponent = new DOBComponent();
        dobComponent.setYear(2024);
        dobComponent.setMonth(10);
        dobComponent.setDay(20); 

        int year = dobComponent.getYear();
        int month = dobComponent.getMonth();
        int day = dobComponent.getDay();

        assertEquals(2024, year, "Expected year 2024 but got " + year);
        assertEquals(10, month, "Expected month 10 but got " + month);
        assertEquals(20, day, "Expected day 20 but got " + day);
    }


    // lastly for address:
     @Test
    public void addressComponentSetterGetterTest() {
    
        AddressComponent addressComponent = new AddressComponent();
        addressComponent.setAddress("4400 University Dr, Fairfax, VA 22030");  // our school address
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
    }

    






    // all test will be testing for the 'happy path' we will implement error handling later in development.
    
}
