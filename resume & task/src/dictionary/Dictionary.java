package dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public static void main(String[] args) {
        List<String> dictionary = List.of("water", "cran", "tart", "goods", "material");
        List<String> text = List.of("can", "oods", "gods", "iran", "mateial");
        List<List<String>> resultDict = new ArrayList<>();

        for (String wordDict : dictionary) {
            String newWord;
            List<String> temp = new ArrayList<>();
            for (int i = 1; i <= wordDict.length(); i++) {
                newWord = wordDict.substring(0, i - 1) + wordDict.substring(i);
                temp.add(newWord);
            }
            resultDict.add(temp);
        }
        for (String wordText : text) {
            for (int i = 0; i < resultDict.size(); i++) {
                if (resultDict.get(i).contains(wordText)) {
                    System.out.printf("Pair: %s and %s\n", wordText, dictionary.get(i));
                    break;
                }
            }
        }
    }
}
