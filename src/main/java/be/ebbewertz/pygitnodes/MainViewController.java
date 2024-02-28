package be.ebbewertz.pygitnodes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

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

        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<String> outputs = new ArrayList<>();

        inputs.add("IN_A");
        inputs.add("IN_B");

        outputs.add("OUT_A");
        outputs.add("OUT_B");

        PyGitNode pyGitNode = new PyGitNode("testNodeFile", "testNodeFunc", "test node", "T", inputs, outputs);

        FileIOManager.writeJson(pyGitNode);
        FileIOManager.writePythonTemplate(pyGitNode);

    }

    private void createNewPyNode(ActionEvent actionEvent) {
        Label label = new Label("PyNode");
        pyNodesSelectionList.getChildren().add(label);
    }
}
