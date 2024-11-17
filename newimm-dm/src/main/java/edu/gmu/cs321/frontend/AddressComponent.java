package edu.gmu.cs321.frontend;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddressComponent extends VBox {
    private TextField addressField;
    private TextField zipcodeField;
    private TextField countryField;
    private TextField stateField;

    public AddressComponent() {
        // Create and add UI elements to the AddressComponent
        Label addressLabel = new Label("Address:");
        addressField = new TextField(); // TextField for address

        Label zipcodeLabel = new Label("Zipcode:");
        zipcodeField = new TextField(); // TextField for zipcode

        Label countryLabel = new Label("Country:");
        countryField = new TextField(); // TextField for country

        Label stateLabel = new Label("State:");
        stateField = new TextField(); // TextField for state

        // Add all elements to the layout
        getChildren().addAll(addressLabel, addressField, zipcodeLabel, zipcodeField, countryLabel, countryField, stateLabel, stateField);
    }

    // Getter for address
    public String getAddress() {
        return addressField.getText();
    }

    public void setAddress(String address) {
        addressField.setText(address);
    }

    // Getter for zipcode
    public int getZipcode() {
        try {
            return Integer.parseInt(zipcodeField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setZipcode(int zipcode) {
        zipcodeField.setText(String.valueOf(zipcode));
    }

    // Getter for country
    public String getCountry() {
        return countryField.getText();
    }

    public void setCountry(String country) {
        countryField.setText(country);
    }

    // Getter for state
    public String getState() {
        return stateField.getText();
    }

    public void setState(String state) {
        stateField.setText(state);
    }
}
