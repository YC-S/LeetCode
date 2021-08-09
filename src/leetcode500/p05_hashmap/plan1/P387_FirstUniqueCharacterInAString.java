package leetcode500.p05_hashmap.plan1;

public class P387_FirstUniqueCharacterInAString {
  public int firstUniqChar(String s) {
    char[] arr = new char[26];
    for (char c : s.toCharArray()) {
      arr[c - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (arr[s.charAt(i) - 'a'] == 1) return i;
    }
    return -1;
  }
}
