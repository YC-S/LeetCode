package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
  public static List<Character> longestCommonSubsequence(String str1, String str2) {
    List<List<List<Character>>> lcs = new ArrayList<>();
    for (int i = 0; i < str2.length() + 1; i++) {
      lcs.add(new ArrayList<List<Character>>());
      for (int j = 0; j < str1.length() + 1; j++) {
        lcs.get(i).add(new ArrayList<>());
      }
    }
    for (int i = 1; i < str2.length() + 1; i++) {
      for (int j = 1; j < str1.length() + 1; j++) {
        if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
          List<Character> copy = new ArrayList<>(lcs.get(i - 1).get(j - 1));
          lcs.get(i).set(j, copy);
          lcs.get(i).get(j).add(str2.charAt(i - 1));
        } else {
          if (lcs.get(i - 1).get(j).size() > lcs.get(i).get(j - 1).size()) {
            lcs.get(i).set(j, lcs.get(i - 1).get(j));
          } else {
            lcs.get(i).set(j, lcs.get(i).get(j - 1));
          }
        }
      }
    }
    return lcs.get(str2.length()).get(str1.length());
  }
}
