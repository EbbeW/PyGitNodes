package be.ebbewertz.pygitnodes;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class DialogViewController {

    @FXML
    public DialogPane dialogPane;
    @FXML
    public TextField newInputNameField;
    @FXML
    public Button newInputButton;
    @FXML
    public TextField newOutputNameField;
    @FXML
    public Button newOutputButton;
    @FXML
    public TextField nameField;
    @FXML
    public TextField shortNameField;
    @FXML
    public VBox inputsList;
    @FXML
    public VBox outputsList;

    Node okButton;
    Node cancelButton;

    @FXML
    public void initialize(){
        okButton = dialogPane.lookupButton(ButtonType.OK);
        cancelButton = dialogPane.lookupButton(ButtonType.CANCEL);
        ((Button)okButton).setOnAction(this::generateFiles);
        newInputButton.setOnAction(this::createInput);
        newOutputButton.setOnAction(this::createOutput);
        updateDisables();


        ChangeListener<String> algemeneUpdateBijTextEdit = (observableValue, s, t1) -> updateDisables();
        newInputNameField.textProperty().addListener(algemeneUpdateBijTextEdit);
        newOutputNameField.textProperty().addListener(algemeneUpdateBijTextEdit);
        nameField.textProperty().addListener(algemeneUpdateBijTextEdit);
        shortNameField.textProperty().addListener(algemeneUpdateBijTextEdit);
    }

    private void createOutput(ActionEvent actionEvent) {
        outputsList.getChildren().add(new Label(newOutputNameField.getText()));
        newOutputNameField.clear();
    }

    private void createInput(ActionEvent actionEvent) {
        inputsList.getChildren().add(new Label(newInputNameField.getText()));
        newInputNameField.clear();
    }

    private void updateDisables(){
        okButton.setDisable(nameField.getText().isBlank() || shortNameField.getText().isBlank());
        newInputButton.setDisable(newInputNameField.getText().isBlank());
        newOutputButton.setDisable(newOutputNameField.getText().isBlank());
    }

    private void generateFiles(ActionEvent actionEvent) {
        String name = nameField.getText();
        String shortName = shortNameField.getText();
        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<String> outputs = new ArrayList<>();
        for(Node node : inputsList.getChildren()){
            inputs.add(((Label)node).getText());
        }
        for(Node node : outputsList.getChildren()){
            outputs.add(((Label)node).getText());
        }
        String formatName = name.replace(" ", "_");
        PyGitNode pyGitNode = new PyGitNode(formatName, formatName, name, shortName, inputs, outputs);
        FileIOManager.writePythonTemplate(pyGitNode);
        FileIOManager.writeJson(pyGitNode);
    }
}
