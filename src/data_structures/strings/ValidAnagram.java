package data_structures.strings;

// Given two data_structures.strings s and t , write a function to determine if t is an anagram of s.
//
// Example 1:
//
// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:
//
// Input: s = "rat", t = "car"
// Output: false
// Note:
// You may assume the string contains only lowercase alphabets.
//
// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?

public class ValidAnagram {

  public static boolean isAnagram(String s, String t) {
    int[] buckets = new int[256];
    char[] array = s.toCharArray();
    for (char c : array) {
      buckets[c - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      buckets[t.charAt(i) - 'a']--;
      if (buckets[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isAnagram("rat", "cat"));
    System.out.println(isAnagram("anagram", "nagaram"));
  }
}
