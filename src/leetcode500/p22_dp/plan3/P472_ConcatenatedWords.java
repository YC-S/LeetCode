package leetcode500.p22_dp.plan3;

import java.util.*;

public class P472_ConcatenatedWords {
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> res = new ArrayList<>();
    if (words == null || words.length == 0) return res;
    Set<String> set = new HashSet<>();
    Arrays.sort(words, Comparator.comparingInt(String::length));
    for (String word : words) {
      if (helper(word, set)) {
        res.add(word);
      }
      set.add(word);
    }
    return res;
  }

  private boolean helper(String word, Set<String> set) {
    if (word == null || word.length() == 0) return false;
    if (set.size() == 0) return false;
    int n = word.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(word.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }
}
