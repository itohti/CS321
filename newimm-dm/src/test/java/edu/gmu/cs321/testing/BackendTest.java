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
    // make the backend class variables so that it will visible to all the testing methods in this class
    ValidateImm validateImm = null;
    ValidateAddress validateAddress = null;
    Validate validate = null;


    @Test
    public void testConstruction() {
        // This method will test the construction of each class.
        // This will fail if any of the objects fail to construct
        validateImm = new ValidateImm();
        validateAddress = new ValidateAddress();
        validate = new Validate();


        assertNotNull(validateImm, "object validateImm did not construct sucessfully.");
        assertNotNull(validateAddress, "object validateAddress did not construct sucessfully.");
        assertNotNull(validate, "object validate did not construct sucessfully.");
    }
}
