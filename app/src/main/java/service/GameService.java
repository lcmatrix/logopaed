/*
 * Created on 29.06.2016
 * 
 * Copyright(c) 1995 - 2016 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */

package service;

import java.io.IOException;
import java.util.Properties;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * Service for updating word label.
 */
public class GameService extends Service<Boolean> {

    /**
     * Constant for property: display.time.in.ms
     */
    private static final String DISPLAY_TIME_IN_MS_PROPERTY = "display.time.in.ms";

    /**
     * Constant for property: words.to.show
     */
    private static final String WORDS_TO_SHOW_PROPERTY = "words.to.show";

    /**
     * Properties for running the game.
     */
    private Properties gameProperties;

    /**
     * Counter for numbers of execution.
     */
    private int numbersOfExecution = 0;

    /**
     * Maximum numbers of execution.
     */
    private int maxNumbersOfExecution;

    public GameService() {
        gameProperties = new Properties();
        try {
            gameProperties.load(getClass().getResourceAsStream("/default.properties"));
            maxNumbersOfExecution = Integer.parseInt(gameProperties.getProperty(WORDS_TO_SHOW_PROPERTY));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Task<Boolean> createTask() {
        return new GameTask(Long.parseLong(gameProperties.getProperty(DISPLAY_TIME_IN_MS_PROPERTY)), numbersOfExecution,
                maxNumbersOfExecution);
    }

    public boolean showNextWord() {
        if (numbersOfExecution < maxNumbersOfExecution) {
            restart();
            numbersOfExecution++;
        } else {
            cancelled();
            return false;
        }
        return true;
    }

    /**
     * Task.
     */
    private class GameTask extends Task<Boolean> {

        private long timeToShowWord = 500;
        private int currentExecution;
        private int maxExecution;

        private GameTask(long actualTimeToShowWord, int currentExecution, int maxExecution) {
            this.timeToShowWord = actualTimeToShowWord;
            this.currentExecution = currentExecution;
            this.maxExecution = maxExecution;
        }

        @Override
        protected Boolean call() throws Exception {
            updateProgress(currentExecution, maxExecution);
            updateMessage("Word 1");
            updateValue(false);
            Thread.sleep(timeToShowWord);
            updateMessage("");
            updateValue(true);
            return true;
        }
    }
}
