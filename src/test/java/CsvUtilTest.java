/*
 * Created by norman on 05.02.15.
 */

import model.Word;
import org.junit.Assert;
import org.junit.Test;
import util.CsvUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Unit test for {@link util.CsvUtil}.
 */
public class CsvUtilTest {

    /**
     * CSV file for test.
     */
    private static final String CSV_FILE = "100_hf_Woerter.csv";

    /**
     * Test {@link util.CsvUtil#readCsvFile(java.io.File)}.
     */
    @Test
    public void testReadCsvFile() {
        File file = new File(getClass().getResource(CSV_FILE).getFile());

        try {
            List<Word> words = CsvUtil.readCsvFile(file);
            Assert.assertNotNull(words);
            Assert.assertEquals(100, words.size());
        } catch (IOException e) {
            Assert.fail("Exception: " + e.getMessage());

        }
    }
}
