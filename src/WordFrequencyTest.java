import contentreader.ContentReader;
import contentreader.FileContentReader;
import wordfreqcalculator.WordFreqCalculator;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyTest {
    public static void main(String[] args) {
        FileContentReader contentReader = new ContentReader();
        File file = new File("files/words.txt");

        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " not exists");
        }

        List<String> contents = contentReader.read(file);
        Map<String, Integer> wordCount = new WordFreqCalculator().calcWordFreq(contents);
        for (String word : wordCount.keySet()) {
            System.out.println(word + " " + wordCount.get(word));
        }
    }
}
