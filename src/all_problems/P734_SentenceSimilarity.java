package all_problems;

import java.util.*;

public class P734_SentenceSimilarity {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, Set<String>> wordMap = new HashMap<>();
        for (List<String> pair : similarPairs) {
            wordMap.computeIfAbsent(pair.get(0), s -> new HashSet<>()).add(pair.get(1));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (wordMap.containsKey(sentence1[i]) && wordMap.get(sentence1[i]).contains(sentence2[i])) {
                continue;
            }
            if (wordMap.containsKey(sentence2[i]) && wordMap.get(sentence2[i]).contains(sentence1[i])) {
                continue;
            }
            if (!sentence1[i].equals(sentence2[i])) {
                return false;
            }
        }
        return true;
    }
}
