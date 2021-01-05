package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/23
 */
public class P190_ReverseBits {

  public static int reverseBits(int n) {
    int res = n & 1;
    int i = 1;
    while (i < 32) {
      n >>= 1;
      int tmp = n & 1;
      res <<= 1;
      res += tmp;
      i++;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(reverseBits(43261596));
  }
}
