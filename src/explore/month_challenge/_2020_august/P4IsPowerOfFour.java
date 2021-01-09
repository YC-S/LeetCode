/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_august;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/04
 */
public class P4IsPowerOfFour {

  public boolean isPowerOfFour(int num) {
    return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);
  }
}
