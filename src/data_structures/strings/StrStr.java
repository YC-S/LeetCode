package data_structures.strings;

// Implement strStr().
//
// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of
// haystack.
//
// Example 1:
//
// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:
//
// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
// Clarification:
//
// What should we return when needle is an empty string? This is a great question to ask during an
// interview.
//
// For the purpose of this problem, we will return 0 when needle is an empty string. This is
// consistent to C's strstr() and Java's indexOf().

public class StrStr {

  public static int strStr(String haystack, String needle) {
    // rabin-karp Algorithm
    if (haystack.length() < needle.length()) {
      return -1;
    }
    int i = 0;
    int nee = hash(needle, i, needle.length());

    while (i + needle.length() < haystack.length()) {
      int hay = hash(haystack, i, needle.length());
      if (hay == nee) {
        return i;
      } else {
        i++;
      }
    }
    return -1;
  }

  private static int hash(String s, int i, int l) {
    char[] array = s.toCharArray();
    int res = 0;
    for (int j = i; j < i + l; j++) {
      res *= 26;
      res += array[j] - 'a';
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(strStr("hello", "ll"));
    System.out.println(strStr("aaaaa", "ll"));
  }
}
