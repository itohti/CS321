package edu.gmu.cs321;

import edu.gmu.cs321.frontend.AddressComponent;
import edu.gmu.cs321.frontend.DOBComponent;
import edu.gmu.cs321.frontend.NameComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

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
                String addressEntered = address.getAddress(); // Get address from AddressComponent

                // Query the database to check if the immigrant is a Green Card holder
                boolean isGreenCardHolder = checkGreenCardStatus(addressEntered);

                if (isGreenCardHolder) {
                    messageLabel.setText("The immigrant is a Green Card holder.");
                    messageLabel.setStyle("-fx-text-fill: green;");
                } else {
                    messageLabel.setText("The immigrant is not a Green Card holder.");
                    messageLabel.setStyle("-fx-text-fill: red;");
                }
            }
        });

        mainLayout.getChildren().addAll(name, dob, address, enterButton, messageLabel);

        Scene scene = new Scene(mainLayout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Application to Request Green Card Replacement");
        primaryStage.show();
    }

    // Method to query the database and check if the immigrant has a Green Card
    private boolean checkGreenCardStatus(String address) {
        boolean isGreenCardHolder = false;

        // JDBC database connection setup
        String url = "jdbc:mysql://localhost:3306/green_card_db"; // Change to your database URL
        String user = "root";
        String password = "XxmanxX19";

        String query = "SELECT green_card_holder FROM immigrants WHERE address = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, address); // Set the entered address as the parameter

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                isGreenCardHolder = rs.getBoolean("green_card_holder");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            messageLabel.setText("Database error: " + e.getMessage());
            messageLabel.setStyle("-fx-text-fill: red;");
        }

        return isGreenCardHolder;
    }

    private boolean basicValidateEntry(NameComponent name, DOBComponent dob, AddressComponent address) {
        return basicValidateAddress(address);
    }

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
            return false; // Validation failed
        }

        messageLabel.setText("Address, State, Zipcode, and Country entered successfully");
        messageLabel.setStyle("-fx-text-fill: green;");
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}