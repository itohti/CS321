package edu.gmu.cs321.frontend;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DOBComponent extends VBox {

    private TextField yearField;
    private TextField monthField;
    private TextField dayField;

    public DOBComponent() {
        Label yearLabel = new Label("Year: ");
        yearField = new TextField();

        Label monthLabel = new Label("Month: ");
        monthField = new TextField();

        Label dayLabel = new Label("Day: ");
        dayField = new TextField();

        getChildren().addAll(yearLabel, yearField, monthLabel, monthField, dayLabel, dayField);
    }

    public void setYear(int year) {
        yearField.setText(String.valueOf(year));
    }

    public void setMonth(int month) {
        monthField.setText(String.valueOf(month));
    }

    public void setDay(int day) {
        dayField.setText(String.valueOf(day));
    }

    public int getYear() {
        try {
            return Integer.parseInt(yearField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int getMonth() {
        try {
            return Integer.parseInt(monthField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int getDay() {
        try {
            return Integer.parseInt(dayField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
}
