package be.ebbewertz.pygitnodes;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class NewPyGitNodeCreateDialog extends Dialog<PyGitNode> {

    public NewPyGitNodeCreateDialog() {

        setTitle("Create PyGitNode");

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("dialog-view.fxml"));
        try {
            DialogPane dialogPane = loader.load();
            setDialogPane(dialogPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
