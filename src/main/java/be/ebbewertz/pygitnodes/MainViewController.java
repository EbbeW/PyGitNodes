package be.ebbewertz.pygitnodes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.ArrayList;

public class MainViewController {

    @FXML
    public AnchorPane backgroundPane;
    @FXML
    public TreeView treeView;
    @FXML
    public Button createNewPyNodeButton;


    @FXML
    public void initialize(){
        
        createNewPyNodeButton.setOnAction(this::createNewPyNode);

        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<String> outputs = new ArrayList<>();

        outputs.add("first");
        outputs.add("last");

        updateTreeView();

        PyGitNode pyGitNode = new PyGitNode("testNodeFile", "testNodeFunc", "test node", "T", inputs, outputs);

        FileIOManager.writeJson(pyGitNode);
        FileIOManager.writePythonTemplate(pyGitNode);
    }

    private void createNewPyNode(ActionEvent actionEvent) {
        NewPyGitNodeCreateDialog dialog = new NewPyGitNodeCreateDialog();
        dialog.showAndWait();
        updateTreeView();
    }

    public void updateTreeView(){
        File rootDir = new File(FileIOManager.nodeDataJsonsDir);
        TreeItem<Label> root = new TreeItem("Root");
        root.setExpanded(true);
        treeView.setRoot(root);
        for (File file : rootDir.listFiles()){
            recursiveAddFilesToTree(file, root);
        }
    }
    private void recursiveAddFilesToTree(File parentFile, TreeItem parentItem){

        //add the current file or dir to the tree
        String name = parentFile.isFile() ? FileIOManager.readJson(parentFile.getPath()).displayName : parentFile.getName();
        TreeItem<String> childItem = new TreeItem<>(name);
        parentItem.getChildren().add(childItem);

        //if it is a dir, use recursion further
        if(parentFile.isDirectory()){
            File[] children = parentFile.listFiles();
            for(File child : children){
                recursiveAddFilesToTree(child, childItem);
            }
        }

    }
}
