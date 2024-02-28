package be.ebbewertz.pygitnodes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainViewController {

    @FXML
    public AnchorPane backgroundPane;

    @FXML
    public void initialize(){
        System.out.println("Hello from the controller");
        backgroundPane.getChildren().add(new Label("hello"));
    }
}
