/*
 * Copyright (c) 2020. Yuanchen
 */

package algorithm.chapter1;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/20
 */
public class Q1_1_10 {

  public static void main(String[] args) {
    int[] a = new int[10];
    for (int i = 0; i < 10; i++) {
      a[i] = i * i;
    }
    System.out.println(Arrays.toString(a));
  }

}
