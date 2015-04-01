package control;/*
 * Created by norman on 01.02.15.
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Main controller for logopaed.
 */
public class MainController {

    @FXML
    private AnchorPane contentPane;

    /**
     * Closes the app.
     */
    @FXML
    protected void closeApp() {
        System.exit(0);
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
            Scene helpScene = new Scene(helpPane);
            helpStage.setScene(helpScene);

            HelpController controller = loader.getController();
            controller.setStage(helpStage);

            helpStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
