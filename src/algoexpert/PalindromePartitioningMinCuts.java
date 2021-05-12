package algoexpert;

import java.util.Arrays;

public class PalindromePartitioningMinCuts {
  public static int palindromePartitioningMinCuts(String str) {
    boolean[][] palindromes = new boolean[str.length()][str.length()];
    for (int i = 0; i < str.length(); i++) {
      for (int j = 0; j < str.length(); j++) {
        palindromes[i][j] = i == j;
      }
    }
    for (int length = 2; length < str.length() + 1; length++) {
      for (int i = 0; i < str.length() - length + 1; i++) {
        int j = i + length - 1;
        if (length == 2) {
          palindromes[i][j] = (str.charAt(i) == str.charAt(j));
        } else {
          palindromes[i][j] = (str.charAt(i) == str.charAt(j) && palindromes[i + 1][j - 1]);
        }
      }
    }
    int[] cuts = new int[str.length()];
    Arrays.fill(cuts, Integer.MAX_VALUE);
    for (int i = 0; i < str.length(); i++) {
      if (palindromes[0][i]) {
        cuts[i] = 0;
      } else {
        cuts[i] = cuts[i - 1] + 1;
        for (int j = 1; j < i; j++) {
          if (palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
            cuts[i] = cuts[j - 1] + 1;
          }
        }
      }
    }
    return cuts[str.length() - 1];
  }
}
