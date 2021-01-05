package data_structures.strings;

// Write a function that reverses a string. The input string is given as an data_structures.array of characters
// char[].
//
// Do not allocate extra space for another data_structures.array, you must do this by modifying the input data_structures.array
// in-place with O(1) extra memory.
//
// You may assume all the characters consist of printable ascii characters.
//
//
//
// Example 1:
//
// Input: ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:
//
// Input: ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]
public class ReverseString {
  public static void reverseString(char[] s) {
    for (int i = 0; i < s.length / 2; i++) {
      char tmp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = tmp;
    }
  }

  public static void main(String[] args) {
    String s = "happy coding";
    char[] array = s.toCharArray();
    reverseString(array);
    System.out.println(array);
  }
}
