package be.ebbewertz.pygitnodes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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
        updateDisables();
        newInputNameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                updateDisables();
            }
        });
    }

    public void updateDisables(){
        okButton.setDisable(nameField.getText().isBlank() || shortNameField.getText().isBlank());
        newInputButton.setDisable(newInputNameField.getText().isBlank());
        newOutputButton.setDisable(newOutputNameField.getText().isBlank());
    }
}
