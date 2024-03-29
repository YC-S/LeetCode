package leetcode500.P13_trie.plan1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P720_LongestWordInDictionary {
  public String longestWord(String[] words) {
    Arrays.sort(words);
    Set<String> built = new HashSet<String>();
    String res = "";
    for (String w : words) {
      if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
        res = w.length() > res.length() ? w : res;
        built.add(w);
      }
    }
    return res;
  }
}
