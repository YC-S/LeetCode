/*
 * Copyright (c) 2020. Yuanchen
 */

package algorithm.chapter1;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/20
 */
public class Q1_1_12 {

  public static void main(String[] args) {
    int[] a = new int[10];
    for (int i = 0; i < 10; i++) {
      a[i] = 9 - i;
    }
    for (int i = 0; i < 10; i++) {
      a[i] = a[a[i]];
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
  }

}
