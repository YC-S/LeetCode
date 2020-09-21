/*
 * Copyright (c) 2020. Yuanchen
 */

package algorithm.chapter1;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/20
 */
public class Q1_1_9 {

  public static void main(String[] args) {
    String s = "";
    for (int n = 10; n > 0; n /= 2) {
      s = (n % 2) + s;
    }
    System.out.println(s);
  }

}
