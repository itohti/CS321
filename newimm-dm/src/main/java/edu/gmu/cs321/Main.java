package edu.gmu.cs321;

import edu.gmu.cs321.backend.ValidateAddress;
import edu.gmu.cs321.frontend.AddressComponent;
import edu.gmu.cs321.frontend.DOBComponent;
import edu.gmu.cs321.frontend.NameComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.cs321.Workflow;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {
    Label messageLabel = new Label();
    @Override
    public void start(Stage primaryStage) {
        AddressComponent address = new AddressComponent();
        DOBComponent dob = new DOBComponent();
        NameComponent name = new NameComponent();

        VBox mainLayout = new VBox();

        Button enterButton = new Button("Enter");
        enterButton.setOnAction(event -> {
            // Perform basic validation for address fields
            boolean isValid = basicValidateEntry(name, dob, address);

            if (isValid) {
                Workflow workflow = new Workflow();
                int formId = 1;
                int result = workflow.AddWFItem(formId, "Review");

                // Handle workflow response
                if (result == 0) {
                    messageLabel.setText("Workflow item added successfully for review.");
                    messageLabel.setStyle("-fx-text-fill: green;");
                } else if (result == -1) {
                    messageLabel.setText("Workflow error: Invalid NextStep.");
                    messageLabel.setStyle("-fx-text-fill: red;");
                } else if (result == -2) {
                    messageLabel.setText("Workflow error: Duplicate or invalid FormID.");
                    messageLabel.setStyle("-fx-text-fill: red;");
                }
                clearMessageAfterDelay();
            }

        });

        mainLayout.getChildren().addAll(name, dob, address, enterButton, messageLabel);

        Scene scene = new Scene(mainLayout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Application to Request Green Card Replacement");
        primaryStage.show();
    }


    private boolean basicValidateEntry(NameComponent name, DOBComponent dob, AddressComponent address) {
        return basicValidateAddress(address);

    }







// quick validation for address with messages.
private boolean basicValidateAddress(AddressComponent address) {
    String addressValue = address.getAddress();
    String stateValue = address.getState();
    int zipcodeValue = address.getZipcode();
    String countryValue = address.getCountry();

    // Validation flags
    boolean enteredAddress = addressValue != null && !addressValue.trim().isEmpty();
    boolean enteredState = stateValue != null && !stateValue.trim().isEmpty();
    boolean enteredZipcode = zipcodeValue > 0;
    boolean enteredCountry = countryValue != null && !countryValue.trim().isEmpty();

    if (!enteredAddress || !enteredState || !enteredZipcode || !enteredCountry) {
        StringBuilder errorMessage = new StringBuilder();
        if (!enteredAddress) {
            errorMessage.append("Address cannot be empty! ");
        }
        if (!enteredState) {
            errorMessage.append("State cannot be empty! ");
        }
        if (!enteredZipcode) {
            errorMessage.append("Zipcode cannot be empty and has to be a valid number! ");
        }
        if (!enteredCountry) {
            errorMessage.append("Country cannot be empty! ");
        }
        messageLabel.setText(errorMessage.toString().trim());
        messageLabel.setStyle("-fx-text-fill: red;");
        clearMessageAfterDelay();
        return false; // Validation failed
    }

    messageLabel.setText("Address, State, Zipcode, and Country entered successfully");
    messageLabel.setStyle("-fx-text-fill: green;");
    clearMessageAfterDelay();
    return true;
}



    private void clearMessageAfterDelay() {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            javafx.application.Platform.runLater(() -> messageLabel.setText(""));
        }).start();
    }




    public static void main(String[] args) {
        launch(args);
    }
}