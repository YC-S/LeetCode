package algoexpert.fail_linkedIn.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NonConstructableChange {
  public static int nonConstructibleChange(int[] coins) {
    // Write your code here.
    Arrays.sort(coins);
    Set<Integer> set = new HashSet<>();
    dfs(set, coins, 0, 0);
    int max = 0;
    for (int coin : coins) {
      max += coin;
    }
    for (int i = 1; i <= max; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return max + 1;
  }

  private static void dfs(Set<Integer> set, int[] coins, int index, int cur) {
    if (index == coins.length) {
      set.add(cur);
      return;
    }
    for (int coin : coins) {
      dfs(set, coins, index + 1, cur + coin);
      cur -= coin;
      dfs(set, coins, index + 1, cur);
    }
  }

  public static void main(String[] args) {
    System.out.println(nonConstructibleChange(new int[] {5, 7, 1, 1, 2, 3, 22}));
  }
}
