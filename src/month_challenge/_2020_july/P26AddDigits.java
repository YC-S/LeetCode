/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_july;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/26
 */
public class P26AddDigits {

  public int addDigits(int num) {
    if (num == 0) {
      return 0;
    }
    if (num % 9 == 0) {
      return 9;
    } else {
      return num % 9;
    }
  }
}
