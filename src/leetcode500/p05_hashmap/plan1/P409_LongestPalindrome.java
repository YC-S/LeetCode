package leetcode500.p05_hashmap.plan1;

public class P409_LongestPalindrome {
  public int longestPalindrome(String s) {
    int[] arr = new int[128];
    for (char c : s.toCharArray()) {
      arr[c]++;
    }
    int res = 0;
    boolean odd = false;
    for (int i : arr) {
      if ((i & 1) == 0) res += i;
      else {
        res += i - 1;
        odd = true;
      }
    }
    return odd ? res + 1 : res;
  }
}
