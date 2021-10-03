package leetcode500.P14_hybrid_data_structure.plan2;

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
