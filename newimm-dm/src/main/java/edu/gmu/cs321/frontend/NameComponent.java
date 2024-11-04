package edu.gmu.cs321.frontend;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NameComponent extends VBox {
    private TextField firstNameField;
    private TextField lastNameField;

    public NameComponent() {
        // Create and add UI elements to the NameComponent
        Label firstNameLabel = new Label("First Name:");
        firstNameField = new TextField(); // TextField for first name

        Label lastNameLabel = new Label("Last Name:");
        lastNameField = new TextField(); // TextField for last name

        // Add all elements to the layout
        getChildren().addAll(firstNameLabel, firstNameField, lastNameLabel, lastNameField);
    }

    // Getter for first name
    public String getFirstName() {
        return firstNameField.getText();
    }

    public void setFirstName(String firstName) {
        firstNameField.setText(firstName);
    }

    // Getter for last name
    public String getLastName() {
        return lastNameField.getText();
    }

    public void setLastName(String lastName) {
        lastNameField.setText(lastName);
    }
}
