/*
 * Created by norman on 01.02.15.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

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
}
