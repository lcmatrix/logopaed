package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import service.GameService;

/**
 * Game controller for logoquiz.
 */
public class GameController implements Initializable{

    /**
     * Label for word.
     */
    @FXML
    private Label wordLabel;


    /**
     * Correct button.
     */
    @FXML
    private Button wordCorrectButton;

    /**
     * Wrong button.
     */
    @FXML
    private Button wordWrongButton;

    /**
     * Progress bar.
     */
    @FXML
    private ProgressBar progress;

    /**
     * Property binding for progress bar.
     */
    private SimpleDoubleProperty progressProperty = new SimpleDoubleProperty();

    /**
     * Service to play the game.
     */
    private GameService service = new GameService();

    /**
     * Correct button clicked.
     */
    @FXML
    protected void correctButtonClicked() {
        handleButton();
    }

    /**
     * Wrong button clicked.
     */
    @FXML
    protected void wrongButtonClicked() {
        handleButton();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wordCorrectButton.visibleProperty().bind(service.valueProperty());
        wordWrongButton.visibleProperty().bind(service.valueProperty());
        progress.progressProperty().bind(progressProperty);

        Service<Void> preGameService = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        //ResourceBundle bundle = ResourceBundle.getBundle("i18n/messsage");
                        //String startText = bundle.getString("logopaed.text.game.start");
                        String startText = "Spiel startet in...";
                        updateMessage(startText + " 3");
                        Thread.sleep(1000);
                        updateMessage(startText + " 2");
                        Thread.sleep(1000);
                        updateMessage(startText + " 1");
                        Thread.sleep(1000);
                        return null;
                    }
                };
            }
        };

        wordLabel.textProperty().bind(preGameService.messageProperty());
        preGameService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                wordLabel.textProperty().unbind();

                wordLabel.textProperty().bind(service.messageProperty());
                service.showNextWord();
            }
        });
        preGameService.restart();
    }

    /**
     * This method updates the progressProperty and runs the service again. If the maximum number of executions has been
     * reached, it cleans up all bindings.
     */
    private void handleButton() {
        progressProperty.setValue(progressProperty.get() + 0.1);
        if (!service.showNextWord()) {
            // finish.. clean up
            wordLabel.textProperty().unbind();
            wordWrongButton.visibleProperty().unbind();
            wordCorrectButton.visibleProperty().unbind();
            progress.progressProperty().unbind();

            wordLabel.setText("Ende");
            wordCorrectButton.setVisible(false);
            wordWrongButton.setVisible(false);
        }
    }
}
