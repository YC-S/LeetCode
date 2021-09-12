package leetcode500.P07_sliding_window.plan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P438_FindAllAnagramsInAString {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int ns = s.length(), np = p.length();
    if (ns < np) {
      return res;
    }
    int[] pCount = new int[26];
    int[] sCount = new int[26];
    for (char ch : p.toCharArray()) {
      pCount[ch - 'a']++;
    }
    for (int i = 0; i < ns; i++) {
      sCount[s.charAt(i) - 'a']++;
      if (i >= np) {
        sCount[s.charAt(i - np) - 'a']--;
      }
      if (Arrays.equals(pCount, sCount)) {
        res.add(i - np + 1);
      }
    }
    return res;
  }
}
