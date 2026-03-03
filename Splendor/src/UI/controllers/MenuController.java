package UI.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.VBox;

public class MenuController {

    @FXML private AnchorPane root;
    @FXML private ImageView bg;
    @FXML private VBox menuBox;

    private static final double BASE_W = 1400;
    private static final double BASE_H = 900;

    @FXML
    public void initialize() {
        // Background stretches to fill window
        bg.fitWidthProperty().bind(root.widthProperty());
        bg.fitHeightProperty().bind(root.heightProperty());
        bg.setPreserveRatio(false);
        bg.setSmooth(true);

        // Scale the menu (buttons + text) uniformly with window size
        var scale = Bindings.createDoubleBinding(
                () -> Math.min(root.getWidth() / BASE_W, root.getHeight() / BASE_H),
                root.widthProperty(), root.heightProperty()
        );

        menuBox.scaleXProperty().bind(scale);
        menuBox.scaleYProperty().bind(scale);
    }

    @FXML
    private void onPlay() {
        try {
            Parent gameRoot = FXMLLoader.load(getClass().getResource("/UI/views/game.fxml"));
            Stage stage = (Stage) root.getScene().getWindow();            
            stage.setScene(new Scene(gameRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onQuit() {
        Platform.exit();
    }
}
