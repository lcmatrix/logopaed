/*
 * Created by norman on 01.04.15.
 */
package control;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Controller for help dialog.
 */
public class HelpController {

    private Stage helpStage;

    /**
     * Close action.
     */
    @FXML
    public void close() {
        helpStage.close();
    }

    /**
     * Sets the stage.
     * @param stage Stage
     */
    public void setStage(Stage stage) {
        this.helpStage = stage;
    }
}
