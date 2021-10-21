package leetcode500.p06_string.plan6;

import java.util.ArrayList;
import java.util.List;

public class P792_NumberOfMatchingSubsequences {
  public int numMatchingSubseq(String S, String[] words) {
    int ans = 0;
    List[] waiting = new List[128];
    for (int c = 'a'; c <= 'z'; c++) waiting[c] = new ArrayList<>();
    for (String word : words) waiting[word.charAt(0)].add(new StringBuilder(word));

    for (char c : S.toCharArray()) {
      List<StringBuilder> advance = waiting[c];

      waiting[c] = new ArrayList<>();

      for (StringBuilder it : advance) {
        it.deleteCharAt(0);
        if (it.length() != 0) waiting[it.charAt(0)].add(it);
        else ans++;
      }
    }
    return ans;
  }
}
