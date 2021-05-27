package all_problems;

import java.util.*;

public class P1772_SortFeaturesByPopularity {
  public String[] sortFeatures(String[] features, String[] responses) {
    Map<String, Integer> freq = new HashMap<>();
    for (String feature : features) {
      freq.put(feature, 0);
    }
    for (String res : responses) {
      Set<String> myWordSet = new HashSet<>();
      Collections.addAll(myWordSet, res.split(" "));
      for (String word : myWordSet) {
        if (freq.containsKey(word)) freq.put(word, freq.get(word) + 1);
      }
    }
    Arrays.sort(features, (a, b) -> freq.get(b) - freq.get(a));
    return features;
  }
}
