package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class GameApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Splendor");

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("/UI/views/menu.fxml"))
        );

        stage.setScene(new Scene(root, 1400, 900));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}