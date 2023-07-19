package wordfreqcalculator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordFreqCalculator {
    public Map<String, Integer> calcWordFreq(List<String> listRow) {
        Map<String, Integer> wordsCount = new HashMap<>();

        for (String row : listRow) {
            String[] words = row.split(" ");
            for (String word : words) {
                int count = wordsCount.getOrDefault(word, 0) + 1;
                wordsCount.put(word, count);
            }
        }

        Map<String, Integer> sortedWordCount = new LinkedHashMap<>();
        while (wordsCount.size() > 0) {
            String key = getKeyWithMaxValue(wordsCount);
            sortedWordCount.put(key, wordsCount.get(key));
            wordsCount.remove(key);
        }

        return sortedWordCount;
    }

    private String getKeyWithMaxValue(Map<String, Integer> map) {
        int minValue = 0;
        String keySearch = "";
        for (String s : map.keySet()) {
            int currValue = map.get(s);
            if (currValue > minValue) {
                minValue = currValue;
                keySearch = s;
            }
        }

        return keySearch;
    }
}
