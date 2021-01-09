/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_may;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/28
 */
public class P28CountingBits {

  public static void main(String[] args) {
    P28CountingBits p28CountingBits = new P28CountingBits();
    System.out.println(Arrays.toString(p28CountingBits.countBits(2)));
    System.out.println(Arrays.toString(p28CountingBits.countBits(5)));
  }

  public int[] countBits(int num) {
    int[] f = new int[num + 1];
    int i;
    f[0] = 0;
    for (i = 1; i <= num; ++i) {
      f[i] = f[i & (i - 1)] + 1;
    }

    return f;
  }
}
