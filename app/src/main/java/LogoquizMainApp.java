/*
 * Created by norman on 01.02.15.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * Main class for Logoquiz app.
 */
public class LogoquizMainApp extends Application {

    /**
     * Root layout of the application.
     */
    private VBox rootLayout;

    /**
     * main() method.
     * @param args arguments
     */
    public static final void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        rootLayout = FXMLLoader.load(getClass().getResource("fxml/rootLayout.fxml"), ResourceBundle.getBundle("i18n/message"));
        stage.setTitle("Logoquiz");
        stage.setScene(new Scene(rootLayout));
        stage.show();
    }
}
