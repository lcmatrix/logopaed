/*
 * Created by norman on 01.02.15.
 */
package control;

import java.io.IOException;
import java.util.ResourceBundle;

import app.LogoquizMainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Main controller for logoquiz.
 */
public class MainController {

    private LogoquizMainApp mainApp;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private TextField anzahlWoerterInput;

    @FXML
    private TextField eingabeZeitspanne;

    @FXML
    private Button startButton;

    /**
     * Closes the app.
     */
    @FXML
    protected void closeApp() {
        System.exit(0);
    }

    /**
     * TODO
     */
    @FXML
    protected void changeSettings() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/rootScene.fxml"));
            loader.setResources(ResourceBundle.getBundle("i18n/message"));
            Pane pane = loader.load();
            contentPane.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Open help dialog.
     */
    @FXML
    protected void showHelpDialog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/helpDialog.fxml"));
            loader.setResources(ResourceBundle.getBundle("i18n/message"));
            VBox helpPane = loader.load();

            Stage helpStage = new Stage();
            helpStage.setTitle(loader.getResources().getString("logopad.help.title"));
            helpStage.initOwner(mainApp.getPrimaryStage());
            helpStage.initModality(Modality.WINDOW_MODAL);
            Scene helpScene = new Scene(helpPane);
            helpStage.setScene(helpScene);

            HelpController controller = loader.getController();
            controller.setStage(helpStage);

            helpStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load and set game scene.
     */
    @FXML
    protected void loadGameScene() {
        System.out.println("Spiel gestartet...");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/gameScene.fxml"));
            loader.setResources(ResourceBundle.getBundle("i18n/message"));
            VBox gamePane = loader.load();
            contentPane.getChildren().clear();
            contentPane.getChildren().add(gamePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Setter for mainApp.
     * @param mainApp the {@link LogoquizMainApp} instance
     */
    public void setMainApp(LogoquizMainApp mainApp) {
        this.mainApp = mainApp;
    }
}
