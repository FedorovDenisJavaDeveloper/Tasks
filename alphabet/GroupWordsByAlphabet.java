package alphabet;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupWordsByAlphabet {
    public static void main(String[] args) {
        String[] words = {"ate", "eta", "nat", "via", "pom", "eat", "atn", "omp", "tea"};
        String sortedWord;
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : words) {
            sortedWord = Stream.of(word.split("")).sorted().collect(Collectors.joining());
            if (!groups.containsKey(sortedWord)) {
                groups.put(sortedWord, new ArrayList<>());
            }
            groups.get(sortedWord).add(word);
        }
        groups.forEach((key, value) -> System.out.println(value));
    }
}
