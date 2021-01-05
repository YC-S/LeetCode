package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/23
 */
public class P191_NumberOf1Bits {

  public static int hammingWeight(int n) {
    int res = 0;
    while (n != 0) {
      res += n & 1;
      n >>>= 1;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(hammingWeight(0b00000000000000000000000000001011));
  }
}
