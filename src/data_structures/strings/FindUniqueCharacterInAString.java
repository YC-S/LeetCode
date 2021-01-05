package data_structures.strings;

// Given a string, find the first non-repeating character in it and return it's index. If it doesn't
// exist, return -1.
//
// Examples:
//
// s = "leetcode"
// return 0.
//
// s = "loveleetcode",
// return 2.

public class FindUniqueCharacterInAString {

  public static int firstUniqChar(String s) {
    int[] buckets = new int[256];
    char[] array = s.toCharArray();
    for (char c : array) {
      buckets[c - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (buckets[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(firstUniqChar("leetcode"));
    System.out.println(firstUniqChar("loveleetcode"));
  }
}
