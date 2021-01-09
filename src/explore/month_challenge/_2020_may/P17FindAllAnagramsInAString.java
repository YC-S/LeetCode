/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/17
 */
public class P17FindAllAnagramsInAString {

  public static List<Integer> findAnagrams(String s, String p) {
    int ns = s.length(), np = p.length();
    if (ns < np) {
      return new ArrayList();
    }

    int[] pCount = new int[26];
    int[] sCount = new int[26];
    // build reference data_structures.array using string p
    for (char ch : p.toCharArray()) {
      pCount[ch - 'a']++;
    }

    List<Integer> output = new ArrayList();
    // sliding window on the string s
    for (int i = 0; i < ns; ++i) {
      // add one more letter
      // on the right side of the window
      sCount[s.charAt(i) - 'a']++;
      // remove one letter
      // from the left side of the window
      if (i >= np) {
        sCount[s.charAt(i - np) - 'a']--;
      }
      // compare data_structures.array in the sliding window
      // with the reference data_structures.array
      if (Arrays.equals(pCount, sCount)) {
        output.add(i - np + 1);
      }
    }
    return output;
  }

  public static void main(String[] args) {
    System.out.println(findAnagrams("cbaebabacd", "abc"));
  }
}
