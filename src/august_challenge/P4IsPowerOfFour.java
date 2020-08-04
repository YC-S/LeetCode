/*
 * Copyright (c) 2020. Yuanchen
 */

package august_challenge;

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
