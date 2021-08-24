package leetcode500.p21_union_find.plan1;

import java.util.*;

public class P734_SentenceSimilarity {
  public boolean areSentencesSimilar(
      String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
    if (sentence1.length != sentence2.length) return false;
    Map<String, Set<String>> map = new HashMap<>();
    for (List<String> pair : similarPairs) {
      map.computeIfAbsent(pair.get(0), s -> new HashSet<>()).add(pair.get(1));
    }
    for (int i = 0; i < sentence1.length; i++) {
      if (map.containsKey(sentence1[i]) && map.get(sentence1[i]).contains(sentence2[i])) continue;
      if (map.containsKey(sentence2[i]) && map.get(sentence2[i]).contains(sentence1[i])) continue;
      if (!sentence1[i].equals(sentence2[i])) return false;
    }
    return true;
  }
}
