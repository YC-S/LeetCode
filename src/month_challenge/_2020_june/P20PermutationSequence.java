/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_june;

import java.util.ArrayList;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/20
 */
public class P20PermutationSequence {

  public String getPermutation(int n, int k) {
    StringBuilder sb = new StringBuilder();
    ArrayList<Integer> num = new ArrayList<Integer>();
    int fact = 1;
    for (int i = 1; i <= n; i++) {
      fact *= i;
      num.add(i);
    }
    for (int i = 0, l = k - 1; i < n; i++) {
      fact /= (n - i);
      int index = (l / fact);
      sb.append(num.remove(index));
      l -= index * fact;
    }
    return sb.toString();
  }
}
