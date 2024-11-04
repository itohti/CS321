package edu.gmu.cs321;

import edu.gmu.cs321.frontend.AddressComponent;
import edu.gmu.cs321.frontend.DOBComponent;
import edu.gmu.cs321.frontend.NameComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        AddressComponent address = new AddressComponent();
        DOBComponent dob = new DOBComponent();
        NameComponent name = new NameComponent();
        
        VBox mainLayout = new VBox();

        mainLayout.getChildren().addAll(name, dob, address);

        Scene scene = new Scene(mainLayout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Application to Request Green Card Replacement");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}