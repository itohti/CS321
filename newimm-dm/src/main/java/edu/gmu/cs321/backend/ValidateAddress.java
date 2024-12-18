package edu.gmu.cs321.backend;
/**
 * ValidateAddress will handle calling the database and validating the address variable to see if its a valid address.
 * Class variable address will contain the address if setAddress is called otherwise the default value is null.
 */
public class ValidateAddress {
    private String address = null;

    /**
     * This method will take the argument and set it to address.
     * @param string
     */
    public void setAddress(String string) {
       this.address = string;
    }

    /**
     * This method will return the address.
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * This method will go through the database and validate address.
     * It will be important to check if the name is not null if it is throw an IllegalStateException.
     * @return boolean
     */
    public boolean validateAddress() throws IllegalStateException{

        return false;
    }
    
}
