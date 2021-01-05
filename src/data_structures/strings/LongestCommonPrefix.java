package data_structures.strings;

// Write a function to find the longest common prefix string amongst an data_structures.array of data_structures.strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
// Input: ["flower","flow","flight"]
// Output: "fl"
// Example 2:
//
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input data_structures.strings.
public class LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {
    int i = 0;
    int equal = 0;
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < strs.length; j++) {
      min = Math.min(min, strs[j].length());
    }
    while (i < min) {
      String tmp = strs[0];
      for (int j = 1; j < strs.length; j++) {
        if (tmp.charAt(i) != strs[j].charAt(i)) {
          return strs[0].substring(0, i);
        }
      }
      if (equal == 0) {
        i++;
      } else {
        return strs[0].substring(0, i);
      }
    }
    return strs[0].substring(0, i);
  }

  public static void main(String[] args) {
    String[] strs = {"dog", "racecar", "car"};
    String[] strs2 = {"flower", "flow", "flight"};
    String[] strs3 = {"a"};
    String[] strs4 = {"c", "c"};
    String[] strs5 = {"c", "acc", "ccc"};
    System.out.println(longestCommonPrefix(strs));
    System.out.println(longestCommonPrefix(strs2));
    System.out.println(longestCommonPrefix(strs3));
    System.out.println(longestCommonPrefix(strs4));
    System.out.println(longestCommonPrefix(strs5));
  }
}
