package edu.gmu.cs321.frontend;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class NameComponent extends VBox{
    public NameComponent() {
        // Add UI elements to the NameComponent
        Label label = new Label("Name Section");
        getChildren().add(label);
    }

    public void setFirstName(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFirstName'");
    }

    public String getFirstName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirstName'");
    }

    public void setLastName(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLastName'");
    }

    public String getLastName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastName'");
    }
    
}
