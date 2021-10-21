package leetcode500.p06_string.plan6;

import java.util.List;
import java.util.PriorityQueue;

public class P524_LongestWordInDictionaryThroughDeleting {
  public String findLongestWord(String s, List<String> dictionary) {
    PriorityQueue<String> pq =
        new PriorityQueue<>(
            (o1, o2) -> {
              if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
              } else {
                return o2.length() - o1.length();
              }
            });
    for (String word : dictionary) {
      if (isSubseq(word, s)) pq.add(word);
    }
    if (pq.size() == 0) return "";
    else return pq.poll();
  }

  private boolean isSubseq(String word, String s) {
    int i = 0, j = 0;
    while (i < word.length() && j < s.length()) {
      if (word.charAt(i) == s.charAt(j)) {
        i++;
        j++;
      } else {
        j++;
      }
    }
    return i == word.length();
  }
}
