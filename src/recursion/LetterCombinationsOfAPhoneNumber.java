package recursion;

import java.util.LinkedList;
import java.util.List;

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
// the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
// does not map to any letters.
//
// Example:
//
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class LetterCombinationsOfAPhoneNumber {

  public static List<String> letterCombinations(String digits) {
    LinkedList<String> res = new LinkedList<>();
    if (digits == null || digits.length() == 0) {
      return res;
    }
    String[] mapping =
      new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    res.add("");
    for (int i = 0; i < digits.length(); i++) {
      int x = Character.getNumericValue(digits.charAt(i));
      while (res.peek().length() == i) {
        String t = res.remove();
        for (char c : mapping[x].toCharArray()) {
          res.add(t + c);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }
}
