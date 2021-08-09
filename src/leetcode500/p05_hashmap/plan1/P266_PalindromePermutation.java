package leetcode500.p05_hashmap.plan1;

public class P266_PalindromePermutation {
  public boolean canPermutePalindrome(String s) {
    char[] arr = new char[26];
    for (char c : s.toCharArray()) {
      arr[c - 'a']++;
    }
    byte count = 0;
    for (int i : arr) {
      if ((i & 1) == 0) continue;
      else count++;
      if (count >= 2) return false;
    }
    return true;
  }
}
