package leetcode500.p06_string.plan6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P527_WordAbbreviation {
  public List<String> wordsAbbreviation(List<String> words) {
    int len = words.size();
    String[] ans = new String[len];
    int[] prefix = new int[len];
    for (int i = 0; i < len; i++) {
      prefix[i] = 1;
      ans[i] = makeAbbr(words.get(i), 1); // make abbreviation for each string
    }
    for (int i = 0; i < len; i++) {
      while (true) {
        HashSet<Integer> set = new HashSet<>();
        for (int j = i + 1; j < len; j++) {
          if (ans[j].equals(ans[i])) set.add(j); // check all strings with the same abbreviation
        }
        if (set.isEmpty()) break;
        set.add(i);
        for (int k : set) ans[k] = makeAbbr(words.get(k), ++prefix[k]); // increase the prefix
      }
    }
    return Arrays.asList(ans);
  }

  private String makeAbbr(String s, int k) {
    if (k >= s.length() - 2) return s;
    StringBuilder sb = new StringBuilder();
    sb.append(s, 0, k);
    sb.append(s.length() - 1 - k);
    sb.append(s.charAt(s.length() - 1));
    return sb.toString();
  }
}
