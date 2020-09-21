/*
 * Copyright (c) 2020. Yuanchen
 */

package algorithm.chapter1;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/20
 */
public class Q1_1_6 {

  public static void main(String[] args) {
    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++) {
      System.out.println(f);
      f = f + g;
      g = f - g;
    }
  }

}
