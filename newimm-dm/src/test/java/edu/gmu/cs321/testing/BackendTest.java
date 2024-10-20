package edu.gmu.cs321.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.gmu.cs321.backend.*;

/**
 * Will test the following classes
 * Validate
 * ValidateAddress
 * ValidateImm
 */
public class BackendTest {
    Validate validate = new Validate();

    // all test will be testing for the 'happy path' we will implement error handling later in development.

    @Test
    public void validateImmGetterSetterFirstName() {
        // Test the getter and setter method for first name.
        ValidateImm validateImm = new ValidateImm();
        validateImm.setFirstName("Izdar");

        String firstName = validateImm.getFirstName();

        assertEquals("Izdar", firstName, "Expected Izdar but got " + firstName);
    }

    @Test
    public void validateImmGetterSetterLastName() {
        // Test the getter and setter method for last name.
        ValidateImm validateImm = new ValidateImm();
        validateImm.setLastName("Tohti");

        String lastName = validateImm.getLastName();

        assertEquals("Tohti", lastName, "Expected Tohti but got " + lastName);
    }

    @Test
    public void validateImmGetterSetterDOB() {
        // Test the getter and setter method for DOB.
        ValidateImm validateImm = new ValidateImm();
        validateImm.setDOB("04/03/2004");

        String DOB = validateImm.getDOB();

        assertEquals("04/03/2004", DOB, "Expected 04/03/2004 but got " + DOB);
    }

    @Test
    public void validateImmTest() {
        // I'm not sure how we can test this we need to wait for the database but for now just return true for everything.
        ValidateImm validateImm = new ValidateImm();
        boolean result = validateImm.validateImm();

        assertTrue(result, "Expected true but got false");
    }

    @Test
    public void validateAddressGetterSetterAddress() {
        // setting the address.
        ValidateAddress validateAddress = new ValidateAddress();

        validateAddress.setAddress("123 main st fairfax 22033");

        String address = validateAddress.getAddress();

        assertEquals("123 main st fairfax 22033", address, "Expected 123 main st fairfax 22033 but got " + address);
    }

    @Test
    public void validateAddressTest() {
        // validates the address. We can't do much without the database so just return true.
        ValidateAddress validateAddress = new ValidateAddress();

        validateAddress.setAddress("123 main st fairfax 22033");

        boolean result = validateAddress.validateAddress();

        assertTrue(result, "Expected true but got false");
    }

    @Test
    public void validateTest() {
        // honestly might just remove this class seems like unneccesary code.

    }
}
