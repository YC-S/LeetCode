package leetcode500.p05_hashmap.plan1;

import java.util.HashSet;
import java.util.Set;

public class P202_HappyNumber {
  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while (n != 1) {
      set.add(n);
      n = helper(n);
      if (set.contains(n)) return false;
    }
    return true;
  }

  private int helper(int n) {
    int res = 0;
    while (n != 0) {
      res += (n % 10) * (n % 10);
      n /= 10;
    }
    return res;
  }
}
