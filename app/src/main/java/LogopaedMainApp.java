/*
 * Created by norman on 01.02.15.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * Main class for Logopaed app.
 */
public class LogopaedMainApp extends Application {

    /**
     * main() method.
     * @param args arguments
     */
    public static final void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("rootScene.fxml"), ResourceBundle.getBundle("message"));
        stage.setTitle("Logopaed");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
