package be.ebbewertz.pygitnodes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.google.gson.Gson;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("PyGitNodes");
        stage.setScene(scene);
        stage.show();
        Person person = new Person("Ebbe", 19);
        Gson gson = new Gson();
        System.out.println(gson.toJson(person));
    }

    public static void main(String[] args) {
        launch();
    }
}