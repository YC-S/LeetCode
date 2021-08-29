package contest.leetcode.单周赛._256;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D {
  public static int numberOfUniqueGoodSubsequences(String binary) {
    List<String> allCombinations = allCombinations(binary);
    Set<Long> set = new HashSet<>();

    for (String str : allCombinations) {
      set.add(Long.parseLong(str));
    }
    return set.size() % 1_000_000_007;
  }

  private static List<String> allCombinations(String binary) {
    List<String> res = new ArrayList<>();
    String ans = "";
    helper(binary, res, ans);
    return res;
  }

  private static void helper(String binary, List<String> res, String ans) {
    if (binary.length() == 0) {
      if (ans.length() != 0) {
        res.add(ans);
      }
      return;
    }
    helper(binary.substring(1), res, ans + binary.charAt(0));
    helper(binary.substring(1), res, ans);
  }

  public static void main(String[] args) {
    System.out.println(numberOfUniqueGoodSubsequences("001"));
    System.out.println(numberOfUniqueGoodSubsequences("11"));
    System.out.println(numberOfUniqueGoodSubsequences("101"));
    System.out.println(numberOfUniqueGoodSubsequences("111001101100000001001110110101110001100"));
  }
}
