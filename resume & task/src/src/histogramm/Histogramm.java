package histogramm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Histogramm {
    public static void main(String[] args) {
        String source = "Hello, world! You are beautiful!";
        Map<Integer, Integer> charCount = new HashMap<>();
        int maxCount = 0;
        for (int symbol : source.toCharArray()) {
            if (!charCount.containsKey(symbol)) {
                charCount.put(symbol, 0);
            }
            charCount.put(symbol, charCount.get(symbol) + 1);
            if (maxCount < charCount.get(symbol)) {
                maxCount = charCount.get(symbol);
            }
        }
        StringBuilder sb = new StringBuilder();
        Integer[] sortedSet = charCount.keySet().stream().sorted().toArray(Integer[]::new);
        for (int i = maxCount; i > 0; i--) {
            for (int j = 0; j < sortedSet.length; j++) {
                if (charCount.get(sortedSet[j]) >= i) {
                    sb.append('#');
                } else {
                    sb.append(".");
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
        Arrays.stream(sortedSet).map(Character::toChars).forEach(System.out::print);
    }
}
