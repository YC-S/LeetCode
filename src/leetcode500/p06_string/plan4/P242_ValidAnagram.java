package leetcode500.p06_string.plan4;

public class P242_ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] arr = new char[255];
    for (char c : s.toCharArray()) {
      arr[c]++;
    }
    for (char c : t.toCharArray()) {
      if (arr[c] > 0) {
        arr[c]--;
      } else {
        return false;
      }
    }
    return true;
  }
}
