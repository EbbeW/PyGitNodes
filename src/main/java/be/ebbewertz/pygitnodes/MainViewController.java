package be.ebbewertz.pygitnodes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainViewController {

    @FXML
    public AnchorPane backgroundPane;
    @FXML
    public VBox pyNodesSelectionList;
    @FXML
    public Button createNewPyNodeButton;

    @FXML
    public void initialize(){
        
        createNewPyNodeButton.setOnAction(this::createNewPyNode);
    }

    private void createNewPyNode(ActionEvent actionEvent) {
        Label label = new Label("PyNode");
        pyNodesSelectionList.getChildren().add(label);
    }
}
