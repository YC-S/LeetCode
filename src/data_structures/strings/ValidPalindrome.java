package data_structures.strings;

// Valid Palindrome
// Given a string, determine if it is a palindrome, considering only alphanumeric characters and
// ignoring cases.
//
// Note: For the purpose of this problem, we define empty string as valid palindrome.
//
// Example 1:
//
// Input: "A man, a plan, a canal: Panama"
// Output: true
// Example 2:
//
// Input: "race a car"
// Output: false
public class ValidPalindrome {

  public static boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }
    s = s.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase();
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    System.out.println(isPalindrome(""));
//    System.out.println(isPalindrome(" "));
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("race a car"));
  }
}
