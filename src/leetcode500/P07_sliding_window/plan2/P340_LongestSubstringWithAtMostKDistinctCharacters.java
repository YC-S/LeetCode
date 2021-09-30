package leetcode500.P07_sliding_window.plan2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P340_LongestSubstringWithAtMostKDistinctCharacters {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n == 0 || k == 0) return 0;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position
    // in the sliding window
    Map<Character, Integer> map = new HashMap<>();

    int diff = 1;

    while (right < n) {
      // add new character and move right pointer
      map.put(s.charAt(right), right);

      // slide window contains 3 characters
      if (map.size() == k + 1) {
        // delete the leftmost character
        int del_idx = Collections.min(map.values());
        map.remove(s.charAt(del_idx));
        // move left pointer of the slide window
        left = del_idx + 1;
      }

      diff = Math.max(diff, right - left + 1);
      right++;
    }
    return diff;
  }
}
