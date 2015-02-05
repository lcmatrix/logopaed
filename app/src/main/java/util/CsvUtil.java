/*
 * Created by norman on 05.02.15.
 */
package util;

import model.Word;
import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Util class for reading csv file.
 */
public class CsvUtil {

    /**
     * Reads csv file and returns a list of {@link model.Word} objects.
     * @param file file to be read
     * @return List of {@link model.Word} objects
     * @throws IOException if file not found or error while reading file
     */
    public static List<Word> readCsvFile(File file) throws IOException {
        CsvPreference prefs =  CsvPreference.STANDARD_PREFERENCE;
        FileReader fileReader = new FileReader(file);
        CsvListReader reader = new CsvListReader(fileReader, prefs);
        List<String> strings = null;
        List<Word> retList = new ArrayList<>();
        while((strings = reader.read()) != null) {
            List<String> incorrectWords = strings.subList(1, strings.size());
            Word word = new Word(strings.get(0), incorrectWords);
            retList.add(word);
        }
        return retList;
    }
}
