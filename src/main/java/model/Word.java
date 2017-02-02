/*
 * Created by norman on 05.02.15.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Model for a word.
 */
public class Word {

    private String correctWord;
    private List<String> incorrectWordsList = new ArrayList<>();

    public Word(String correctWord, List<String> incorrectWordsList) {
        this.correctWord = correctWord;
        if (incorrectWordsList != null) {
            this.incorrectWordsList.addAll(incorrectWordsList);
        }
    }

    /**
     * Getter for correct word.
     * @return correct word
     */
    public String getCorrectWord() {
        return correctWord;
    }

    /**
     * Getter for list with incorrect words.
     * @return list of incorrect words
     */
    public List<String> getIncorrectWordsList() {
        return incorrectWordsList;
    }

    /**
     * Get a random incorrect word.
     * @return an incorrect word
     */
    public String getRandomIncorrectWord() {
        Random r = new Random();
        int index = r.nextInt(incorrectWordsList.size());
        return incorrectWordsList.get(index);
    }
}
