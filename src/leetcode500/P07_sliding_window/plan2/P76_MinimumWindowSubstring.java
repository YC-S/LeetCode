package leetcode500.P07_sliding_window.plan2;

public class P76_MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    if (s == null || t == null) return "";
    int[] array = new int[256];
    int left = 0, right = 0, count = t.length(), start = 0, len = Integer.MAX_VALUE;
    for (int i = 0; i < count; i++) {
      array[t.charAt(i)]++;
    }
    for (; right < s.length(); right++) {
      char r = s.charAt(right);
      if (array[r] > 0) {
        count--;
      }
      array[r]--;
      while (count == 0) {
        if (right - left + 1 < len) {
          start = left;
          len = right - left + 1;
        }
        char l = s.charAt(left);
        array[l]++;
        if (array[l] > 0) {
          count++;
        }
        left++;
      }
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }
}
