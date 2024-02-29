package be.ebbewertz.pygitnodes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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


        PyGitNode pyGitNode = new PyGitNode("testNodeFile", "testNodeFunc", "test node", "T", inputs, outputs);

        FileIOManager.writeJson(pyGitNode);
        FileIOManager.writePythonTemplate(pyGitNode);

    }

    private void createNewPyNode(ActionEvent actionEvent) {
        NewPyGitNodeCreateDialog dialog = new NewPyGitNodeCreateDialog();
        dialog.showAndWait();
    }
}
