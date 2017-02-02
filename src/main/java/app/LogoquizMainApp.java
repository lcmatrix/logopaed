package app;

import java.util.ResourceBundle;

import control.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main class for Logoquiz app.
 */
public class LogoquizMainApp extends Application {

    /**
     * Root layout of the application.
     */
    private VBox rootLayout;

    /**
     * Primary Stage.
     */
    private Stage primaryStage;

    /**
     * main() method.
     * @param args arguments
     */
    public static final void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/rootLayout.fxml"));
        loader.setResources(ResourceBundle.getBundle("i18n/message"));
        rootLayout = loader.load();

        MainController controller = loader.getController();
        controller.setMainApp(this);

        primaryStage.setTitle("Logoquiz");
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }

    /**
     * Getter for primaryStage.
     *
     * @return primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
